package de.tinysite.pico.cloud.delegates;

import de.tinysite.pico.cloud.services.PicoProvisioningService;
import de.tinysite.pico.cloud.services.impl.PicoMailServiceImpl;
import de.tinysite.pico.cloud.services.impl.PicoProvisioningServiceImpl;
import org.flowable.engine.HistoryService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CompleteDeploymentDelegate implements JavaDelegate {
    HistoryService historyService;
    RuntimeService runtimeService;
    private static PicoProvisioningService picoProvisioningService;
     ProcessEngine processEngine;
    TaskService taskService;

    @Autowired
    public void setProvisioningService(PicoProvisioningService provisioningService) {
        this.picoProvisioningService = provisioningService;
    }
    Logger logger = LoggerFactory.getLogger(CompleteDeploymentDelegate.class);
    @Override
    public void execute(DelegateExecution execution) {
        logger.info("Completing Deployment");


            if(!picoProvisioningService.getErrors().isEmpty()){
            }
            picoProvisioningService.getErrors().stream().forEach(e-> {
                        System.out.println(e);
                    });
                picoProvisioningService.getErrors().clear();
            if(!picoProvisioningService.getErrors().isEmpty()){
            picoProvisioningService.getErrors().clear();
            picoProvisioningService.restartExecution(execution);
          }
        }
        }











