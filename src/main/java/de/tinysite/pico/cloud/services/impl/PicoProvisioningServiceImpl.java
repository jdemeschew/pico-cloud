package de.tinysite.pico.cloud.services.impl;

import de.tinysite.pico.cloud.delegates.DeployInstanceDelegate;
import de.tinysite.pico.cloud.deployers.Deployer;
import de.tinysite.pico.cloud.deployers.impl.DummyDeployer;
import de.tinysite.pico.cloud.deployers.impl.LocalHostDeployer;
import de.tinysite.pico.cloud.deployers.impl.PleskDeployer;
import de.tinysite.pico.cloud.dto.PicoSite;
import de.tinysite.pico.cloud.services.PicoMailService;
import de.tinysite.pico.cloud.services.PicoProvisioningService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.flowable.engine.HistoryService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.task.api.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Component
public class PicoProvisioningServiceImpl implements PicoProvisioningService {

    private static final Logger logger = LoggerFactory.getLogger(DeployInstanceDelegate.class);
    private Set<String> requiredFields = new HashSet<>();
    public List<String> errors = new ArrayList<>();


    public final String PICO_WELCOME_EMAIL ="Hello %s, here is the link to your site:\n" +"%s";
    @Value("${pico-site.structure.template.location}")
    private String picoTemplateLocation="";
    @Value("${send-invitation-mail}")
    private Boolean sendInvitationMail;



    public void setPicoConfigFileTemplateLocation(String picoConfigFileTemplateLocation) {
        this.picoConfigFileTemplateLocation = picoConfigFileTemplateLocation;
    }

    public String getPicoConfigFileTemplateLocation() {
        return picoConfigFileTemplateLocation;
    }

    @Value("${pico-site.config-file.template.location}")
    private String picoConfigFileTemplateLocation="";

    public String getPicoSiteTargetLocation() {
        return picoSiteTargetLocation;
    }

    private String picoSiteTargetLocation="";
    @Autowired
    protected Deployer deployer;
    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    PicoMailService picoMailService;
    TaskService taskService;
    HistoryService historyService;
    RuntimeService runtimeService;


    public void setPicoTemplateLocation(String picoTemplateLocation) {
        this.picoTemplateLocation = picoTemplateLocation;
    }

    public void setPicoSiteTargetLocation(String picoSiteTargetLocation) {
        this.picoSiteTargetLocation = picoSiteTargetLocation;
    }
@Override
    public void deploy(PicoSite picoSite, String instanceName)  {
if(sendInvitationMail &&StringUtils.isBlank(picoSite.getUserEmail())){

}
        Path source =Paths.get(picoTemplateLocation);
        Path target =Paths.get(picoSiteTargetLocation,"pico", instanceName);
        processEngine.getRuntimeService();
        try {
            String  siteName = picoSite.getSiteName();
            Path sitePath = deployer.deploy(siteName,"");


            if(sitePath ==null){
                return;
            }
           Path parentPath =  sitePath.getParent();


            FileUtils.deleteDirectory(sitePath.toFile());
            FileUtils.copyDirectory(source.toFile(),sitePath.toFile());
            Map<String,String>  params= new HashMap();
            params.put("site_title", picoSite.getSiteTitle());
            configureInstance(sitePath.toString(),params);
            String link ="https://" + siteName+".tinysite.de";
            configureInstance(sitePath.toFile().getAbsolutePath(),params);
            String content = String.format(PICO_WELCOME_EMAIL,picoSite.getUserFullName(),link);

            picoMailService.send(picoSite.getUserEmail(), "your Pico Site", content);
        } catch (IOException e) {
            logger.error("Error sending mail: {}", e.getMessage());
        }
        System.out.printf("Your site %s has been deployed." , picoSite.getSiteName());
                if(sendInvitationMail){
                    System.out.println("The link will be mailed to you in a few moments.");
    }
    }

    @Override
    public void restartExecution(DelegateExecution execution) {
        runtimeService.deleteProcessInstance(execution.getProcessInstanceId(),"restart process");
        runtimeService.startProcessInstanceById(execution.getProcessDefinitionId(),execution.getVariables());

    }



    @Override
    public void configureInstance(String instancePath, Map<String,String> params) {
        try {
            Path instanceConfigFile=Paths.get(instancePath,"config","config.yml");
            Path templateConfigFileLocation =Paths.get(picoConfigFileTemplateLocation);
            InputStream ios =new FileInputStream(templateConfigFileLocation.toFile());

            StringWriter writer = new StringWriter();
            IOUtils.copy(ios, writer, System.getProperty("file.encoding"));
            String theString = writer.toString();


            String configContent=new String(Files.readAllBytes(templateConfigFileLocation), StandardCharsets.UTF_8);

            StrSubstitutor sub = new StrSubstitutor(params, "{{", "}}");
            String result = sub.replace(configContent);



            FileUtils.writeStringToFile((instanceConfigFile.toFile()),result,StandardCharsets.UTF_8,false);

        } catch (IOException e) {
        }

    }


private void initServices(){
        runtimeService = processEngine.getRuntimeService();
        taskService =processEngine.getTaskService();
        historyService =processEngine.getHistoryService();
}


@Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
@Autowired
    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }
@Autowired
    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
}
    private List<Task> getAllTaskByProcessId(String processInstanceId) {
        return taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .list();

        }
        public List<String>  checkForMissing(DelegateExecution execution){
        initRquiredFields();
            List<String> missing = new ArrayList<>();
        for( String param:requiredFields){
            if(execution.getVariable(param)==null){
                missing.add(param);
            }

        }
        return missing;



        }

    @Override
    public void addError(String error) {
        errors.add(error);

    }

    @Override
    public void addErrors(List<String> errors) {
        errors.addAll(errors);
    }

    @Override
    public List<String> getErrors() {
        return errors;
    }
private  void initRquiredFields(){
        if(deployer instanceof DummyDeployer){
         requiredFields.addAll(Arrays.asList("site-name"));
        }else if (deployer instanceof LocalHostDeployer){
            requiredFields.addAll(Arrays.asList("site-name","site-title"));
            if(sendInvitationMail){
                requiredFields.add("user-mail");
            }
        }else if(deployer instanceof PleskDeployer)
requiredFields.addAll(Arrays.asList("site-name","site-title","user","user-mail"));

}
}