package de.tinysite.pico.cloud.deployers.impl;


import de.tinysite.flufl.plesk.rest.api.DomainsApi;
import de.tinysite.flufl.plesk.rest.dto.*;
import de.tinysite.pico.cloud.deployers.Deployer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*


Implementation of the  Deployer interface using Plesk REST API

 */
//@Component
public class PleskDeployer implements Deployer {
    @Value("${pico-site.structure.template.location}")
    private String picoTemplateLocation = "";
    @Autowired
    DomainsApi domainsApi;
     private Logger logger = LoggerFactory.getLogger(PleskDeployer.class);
     @Value("${plesk-api.base.path}")
    private String  basePath="";

    @Override
    public Path deploy(String siteName, String fileLocation) {
        domainsApi.getApiClient().setBasePath(basePath);
        logger.warn("in deploy Base Path {}",this.basePath);
        List<DomainResponse> domains = domainsApi.domainsGet(null);

        DomainRequest domainRequest = new DomainRequest();

        DomainReference domainReference  =new DomainReference();
        domainReference.setId(domains.get(0).getId());
        domainReference.setName(siteName +".tinysite.de");
        domainRequest.setBaseDomain(domainReference);
        domainRequest.setName(siteName +".tinysite.de");
        domainRequest.setHostingType(DomainRequest.HostingTypeEnum.VIRTUAL);
        DomainRequestHostingSettings domainSettings =new DomainRequestHostingSettings();
        domainRequest.setHostingType(DomainRequest.HostingTypeEnum.VIRTUAL);
        domainRequest.setHostingSettings(domainSettings);
        logger.info("deploy site:{}",siteName);
        CreatedResponse response =domainsApi.domainsPost(domainRequest);
        DomainResponse newDomain = domainsApi.domainsIdGet(response.getId());
        return Paths.get(newDomain.getWwwRoot());


    }



}
