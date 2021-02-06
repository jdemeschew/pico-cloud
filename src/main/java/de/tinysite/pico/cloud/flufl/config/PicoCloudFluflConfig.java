package de.tinysite.pico.cloud.flufl.config;

import de.tinysite.flufl.plesk.rest.api.DomainsApi;
import de.tinysite.pico.cloud.delegates.CompleteDeploymentDelegate;
import de.tinysite.pico.cloud.delegates.DeployInstanceDelegate;
import de.tinysite.pico.cloud.deployers.Deployer;
import de.tinysite.pico.cloud.deployers.impl.DummyDeployer;
import de.tinysite.pico.cloud.deployers.impl.LocalHostDeployer;
import de.tinysite.pico.cloud.deployers.impl.PleskDeployer;
import de.tinysite.pico.cloud.services.PicoMailService;
import de.tinysite.pico.cloud.services.PicoProvisioningService;
import de.tinysite.pico.cloud.services.impl.PicoMailServiceImpl;
import de.tinysite.pico.cloud.services.impl.PicoProvisioningServiceImpl;
import org.flowable.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PicoCloudFluflConfig {

    @ConditionalOnProperty(name="cloud.deployer",havingValue="local")
    @Bean
    Deployer localhostDeployer(){
        return new LocalHostDeployer();
    }
    @ConditionalOnProperty(name="cloud.deployer",havingValue="dummy")
    @Bean
    Deployer dummyDeployer(){
        return new DummyDeployer();
    }
    @Bean
    DeployInstanceDelegate deployInstanceDelegate(){
        return new DeployInstanceDelegate();
    }

    @ConditionalOnProperty(name="cloud.deployer",havingValue="plesk")
    @Bean
    Deployer pleskDeployer(){
        return new PleskDeployer();
    }
    @Bean
    CompleteDeploymentDelegate completeDeploymentDelegate(){
        return new CompleteDeploymentDelegate();
    }
    @Bean
    PicoMailService picoMailService() {
        return new PicoMailServiceImpl();
    }
        @Bean
        RestTemplate restTemplate(){
    return new RestTemplate();
        }
        @Bean
        DomainsApi domainsApi(){
        return new DomainsApi();
        }
}
