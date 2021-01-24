package de.tinysite.pico.cloud.services.impl;


import de.tinysite.flufl.pico.cloud.utils.YamlUtils;
import de.tinysite.pico.cloud.services.PicoProvisioningService;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PicoProvisioningServiceImplTest {
    private static final String CONFIG_FILE="/Users/void/projects/data/config-template.yml";
    @Test
    public void testConfigurePico() {
        PicoProvisioningServiceImpl provisioningService = new PicoProvisioningServiceImpl();
        provisioningService.setPicoConfigFileTemplateLocation("/Users/void/projects/data/config-template.yml");
        Map<String,String>  params= new HashMap();
        params.put("site_title", "Pico URURU");

        provisioningService.configureInstance("/private/var/www/vhosts/tinysite.de/site13",params);

}


}