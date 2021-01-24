package de.tinysite.pico.cloud.services;

import de.tinysite.pico.cloud.dto.PicoSite;

import java.io.IOException;
import java.util.Map;

public interface PicoProvisioningService {

    /*Prepares file location where the Pico instance will be deployed
    public void prepareDir(String instanceName);
    Configures delployed instance using provided params
     */
    public void configureInstance(String instanceName, Map<String,String> params);

/*Deploys configured Pico site  to the web server

 */
    public void deploy(PicoSite picoSite, String instanceName);

}