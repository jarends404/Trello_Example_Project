package nl.example.util;

import java.io.IOException;
import java.util.Properties;

/**
 * This class is responsible for retrieving environment specific information from the property files.
 */
public class Environment {

    private static Environment environment;
    private final Properties properties;
    private static final String PROPERTY_FILE_PATH = "config/%s/environment.properties";
    private static final String ENVIRONMENT_PROPERTY_NAME = "environment";


    private Environment() {
        properties = new Properties();
        readPropertyFile();
    }

    public static Environment getInstance() {
        if (environment == null) {
            environment = new Environment();
        }
        return environment;
    }

    public String getProperty(String keyName) {
        return properties.getProperty(keyName);
    }

    private void readPropertyFile() {
        String path = String.format(PROPERTY_FILE_PATH, System.getProperty(ENVIRONMENT_PROPERTY_NAME));
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(path));
        } catch (IOException ioex) {
            throw new RuntimeException(ioex);
        }
    }
}
