package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream fileInputStream =
                    new FileInputStream("config/config.properties");

            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(
                    "Could not load config.properties file",
                    e
            );
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}