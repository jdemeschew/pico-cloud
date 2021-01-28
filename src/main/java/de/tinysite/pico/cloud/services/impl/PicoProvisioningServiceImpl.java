package de.tinysite.pico.cloud.services.impl;

import de.tinysite.pico.cloud.delegates.DeployInstanceDelegate;
import de.tinysite.pico.cloud.deployers.Deployer;
import de.tinysite.pico.cloud.dto.PicoSite;
import de.tinysite.pico.cloud.services.PicoMailService;
import de.tinysite.pico.cloud.services.PicoProvisioningService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.flowable.engine.ProcessEngine;
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
import java.util.HashMap;
import java.util.Map;

@Component
/**
Plesk specific implementation of the PicoProvisioning Service
 **/
public class PicoProvisioningServiceImpl implements PicoProvisioningService {

    private static final Logger logger = LoggerFactory.getLogger(DeployInstanceDelegate.class);
    private static PicoProvisioningService provisioningService;


    public final String PICO_WELCOME_EMAIL ="Hello %s, here is the link to your site:\n" +"%s";
    @Value("${pico-site.structure.template.location}")
    private String picoTemplateLocation="";

    public void setPicoConfigFileTemplateLocation(String picoConfigFileTemplateLocation) {
        this.picoConfigFileTemplateLocation = picoConfigFileTemplateLocation;
    }

    public String getPicoConfigFileTemplateLocation() {
        return picoConfigFileTemplateLocation;
    }

    @Value("${pico-site.config-file.template.location}")
    private String picoConfigFileTemplateLocation="";
    @Value("${pico-site.config-file.template.location}")

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


    public void setPicoTemplateLocation(String picoTemplateLocation) {
        this.picoTemplateLocation = picoTemplateLocation;
    }

    public void setPicoSiteTargetLocation(String picoSiteTargetLocation) {
        this.picoSiteTargetLocation = picoSiteTargetLocation;
    }
@Override
    public void deploy(PicoSite picoSite, String instanceName)  {

        Path source =Paths.get(picoTemplateLocation);
        Path target =Paths.get(picoSiteTargetLocation,"pico", instanceName);
        processEngine.getRuntimeService();
        try {
            String  siteName = picoSite.getSiteName();
            Path subDomain = deployer.deploy(siteName,"");
            if(subDomain ==null){
                return;
            }
           Path parentPath =  subDomain.getParent();


            FileUtils.deleteDirectory(subDomain.toFile());
            FileUtils.copyDirectory(source.toFile(),subDomain.toFile());
            Map<String,String>  params= new HashMap();
            params.put("site_title", picoSite.getSiteTitle());
            configureInstance(subDomain.toString(),params);
            String link ="https://" + siteName+".tinysite.de";
            configureInstance(subDomain.toFile().getAbsolutePath(),params);
            String content = String.format(PICO_WELCOME_EMAIL,picoSite.getUserFullName(),link);

            picoMailService.send(picoSite.getUserEmail(), "your Pico Site", content);
        } catch (IOException e) {
            logger.error("Error sending mail:{}", e.getMessage());
        }
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



}
