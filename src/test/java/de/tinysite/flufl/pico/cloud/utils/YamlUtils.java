package de.tinysite.flufl.pico.cloud.utils;

import de.tinysite.pico.cloud.delegates.DeployInstanceDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class YamlUtils {
    private static final Logger logger = LoggerFactory.getLogger(YamlUtils.class);
    public static Map<String,String> loadYamlFileIntoMap(File yamlFile){
        Yaml yaml =new Yaml();
        try (InputStream ios = new FileInputStream(yamlFile)) {
            Map<String,String> result =yaml.load(ios);
            return result;
        } catch (FileNotFoundException e) {
           logger.error("file {} could not be found",yamlFile);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return new HashMap<>();
    }
}
