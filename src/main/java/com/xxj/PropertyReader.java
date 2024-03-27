package com.xxj;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties;

    public PropertyReader() {
        properties = new Properties();
        try (InputStream input = getClass().getResourceAsStream("/setting.properties")) {
            properties.load(input);
            if (hasVitalProperty())
                System.out.println(".properties file loaded successfully!");
            else
                throw new RuntimeException("Missing vital properties in setting.properties");
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }


    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public List<String> getPropertyNames() {
        return List.copyOf(properties.stringPropertyNames());
    }

    private boolean hasVitalProperty() {
        return properties.containsKey("folderpath") && properties.containsKey("stringToBeDeleted.last");
    }
}