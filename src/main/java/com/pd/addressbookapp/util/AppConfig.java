package com.pd.addressbookapp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private Properties properties;

    public AppConfig() {
        properties = new Properties();
        try (InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            
            if (inputStream == null) {
                throw new IOException("application.properties not found in classpath");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
