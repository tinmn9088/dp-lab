package by.vsu.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProvider {
    
    private static final String fileAdress = "src/main/webapp/WEB-INF/config.properties";

    public static String getValue(String name) {
        try (InputStream is = new FileInputStream(fileAdress)) {
            Properties prop = new Properties();
            prop.load(is);
            return prop.getProperty(name);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
