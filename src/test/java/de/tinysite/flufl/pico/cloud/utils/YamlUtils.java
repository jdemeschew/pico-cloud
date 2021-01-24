package de.tinysite.flufl.pico.cloud.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class YamlUtils {
    public static Map<String,String> loadYamlFileIntoMap(File yamlFile){
        Yaml yaml =new Yaml();
        try (InputStream ios = new FileInputStream(yamlFile)) {
            Map<String,String> result =yaml.load(ios);
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return new HashMap<>();
    }
}
