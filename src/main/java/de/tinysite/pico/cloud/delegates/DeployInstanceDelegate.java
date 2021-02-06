package de.tinysite.pico.cloud.delegates;


import de.tinysite.pico.cloud.dto.PicoSite;
import de.tinysite.pico.cloud.services.PicoProvisioningService;
import de.tinysite.pico.cloud.services.impl.PicoProvisioningServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
Deploys  Pico Instance  after configuring it using  parameters from the current running process
 */
//@Component
public class DeployInstanceDelegate implements JavaDelegate {
    Logger logger = LoggerFactory.getLogger(DeployInstanceDelegate.class);
    private static PicoProvisioningService provisioningService;
@Autowired
    public void setProvisioningService(PicoProvisioningService provisioningService) {
        this.provisioningService = provisioningService;

    }

    @Override
    public void execute(DelegateExecution execution) {
    List<String> missing  = provisioningService.checkForMissing(execution);

    if(missing.isEmpty()){
     String siteName =execution.getVariable("site-name",String.class);
     String user =execution.getVariable("user",String.class);
     String userMail =execution.getVariable("user-mail",String.class);
     String siteTitle =execution.getVariable("site-title",String.class);
        PicoSite picoSite = new PicoSite();
        picoSite.setSiteName(siteName);
        picoSite.setSiteTitle(siteTitle);
        picoSite.setUserEmail(userMail);
        picoSite.setUserFullName(user);
        provisioningService.deploy(picoSite,"Pico-Test");
        logger.info("Deploying Pico Instance {}",siteName);
        }else {

String template = "Following params are missing: %s. \n Please set them with set-param command and run complete-task again";

String messageMissingFields=String.format(template, String.join(", ",missing));
        provisioningService.addError(messageMissingFields);
        return;
    }


    }

}
