package de.tinysite.pico.cloud.delegates;


import de.tinysite.pico.cloud.dto.PicoSite;
import de.tinysite.pico.cloud.services.PicoProvisioningService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
Deploys  Pico Instance  after configuring it using  parameters from the current running process
 */
@Component
public class DeployInstanceDelegate implements JavaDelegate {
    Logger logger = LoggerFactory.getLogger(DeployInstanceDelegate.class);
    private static PicoProvisioningService provisioningService;
@Autowired
    public void setProvisioningService(PicoProvisioningService provisioningService) {
        this.provisioningService = provisioningService;
    }

    @Override
    public void execute(DelegateExecution execution) {
     String siteName =execution.getVariable("site-name",String.class);
     String user =execution.getVariable("user",String.class);
     String userMail =execution.getVariable("user-mail",String.class);
     String siteTitle =execution.getVariable("site-title",String.class);
        PicoSite picoSite = new PicoSite();
        picoSite.setSiteName(siteName);
        picoSite.setSiteTitle(siteTitle);
        picoSite.setUserEmail(userMail);
        picoSite.setUserFullName(user);
        logger.info("Deploying Pico Instance {}",siteName);
        provisioningService.deploy(picoSite,"Pico-Test");

    }

}
