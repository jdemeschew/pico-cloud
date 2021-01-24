package de.tinysite.pico.cloud.deployers.impl;

import de.tinysite.pico.cloud.deployers.Deployer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class DummyDeployer implements Deployer {
    Logger logger = LoggerFactory.getLogger(DummyDeployer.class);
    @Override
    public Path deploy(String siteName, String fileLocation) {
        logger.info("deploy {} into nowhere",siteName);
        return null;
    }
}
