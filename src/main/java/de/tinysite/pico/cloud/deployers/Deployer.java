package de.tinysite.pico.cloud.deployers;

import java.nio.file.Path;

public interface Deployer {
    public Path deploy(String siteName, String fileLocation);
}
