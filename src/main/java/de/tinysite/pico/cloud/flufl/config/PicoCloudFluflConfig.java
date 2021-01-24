package de.tinysite.pico.cloud.flufl.config;

import de.tinysite.flufl.plesk.rest.api.DomainsApi;
import de.tinysite.pico.cloud.delegates.DeployInstanceDelegate;
import de.tinysite.pico.cloud.deployers.Deployer;
import de.tinysite.pico.cloud.deployers.impl.DummyDeployer;
import de.tinysite.pico.cloud.deployers.impl.FileSystemDeployer;
import de.tinysite.pico.cloud.deployers.impl.PleskDeployer;
import de.tinysite.pico.cloud.services.PicoMailService;
import de.tinysite.pico.cloud.services.PicoProvisioningService;
import de.tinysite.pico.cloud.services.impl.PicoMailServiceImpl;
import de.tinysite.pico.cloud.services.impl.PicoProvisioningServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PicoCloudFluflConfig {
    @ConditionalOnProperty(name="cloud.deployer",havingValue="plesk")
    @Bean
    Deployer pleskDeployer(){
        return new PleskDeployer();
    }
    @ConditionalOnProperty(name="cloud.deployer",havingValue="file-system")
    @Bean
    Deployer fileSystemDeployer(){
        return new FileSystemDeployer();
    }
    @ConditionalOnProperty(name="cloud.deployer",havingValue="dummy")
    //@Bean
    //@Primary
    Deployer dummyDeployer(){
        return new DummyDeployer();
    }
    DeployInstanceDelegate deployInstanceDelegate(){
        return new DeployInstanceDelegate();
    }
    @Bean
    PicoMailService picoMailService() {
        return new PicoMailServiceImpl();
    }
        //@Bean
        PicoProvisioningService provisioningService(){
            return  new PicoProvisioningServiceImpl();
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
