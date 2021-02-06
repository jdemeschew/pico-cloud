package de.tinysite.pico.cloud.deployers.impl;

import de.tinysite.pico.cloud.deployers.Deployer;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

//@Component
public class LocalHostDeployer implements Deployer {
    Logger logger = LoggerFactory.getLogger(LocalHostDeployer.class);
    @Value("${pico-site.structure.template.location}")
    private String picoTemplateLocation="";

    @Value("${htdocs.location}")
    private String htdocsLocation="";
    @Value("${local-pico-cloud.base-url:}")
    private String  baseUrl="";
    @Value("${localhost.base-url}")
    private String localhostBaseUrl="";



    @Override
    public Path deploy(String siteName, String fileLocation) {
        String siteUrl =localhostBaseUrl+"/"+siteName;
        Path sourcePath = Paths.get(picoTemplateLocation);
        Path targetPath=Paths.get(htdocsLocation,siteName);
        try {
            FileUtils.deleteDirectory(targetPath.toFile());
            FileUtils.copyDirectory(sourcePath.toFile(),targetPath.toFile());
            System.out.println(String.format("Pico site has been deployed and can be reached under: %s",siteUrl));
        } catch (IOException e) {
            logger.error("could not deploy site {}",siteName);
        }
logger.info("Deployment complete");
return targetPath;

}}
