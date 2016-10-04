package helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Sander Geraedts on 3-10-16.
 */
public class FunCrate {

    public static String CONFIG_FILE_PATH = "config/config.properties";

    public static String getConfigValue(String key) throws IOException {
        String value = "";

        Properties properties = new Properties();
        String propFile = FunCrate.CONFIG_FILE_PATH;
        InputStream inputStream = properties.getClass().getClassLoader().getResourceAsStream(propFile);

        if(inputStream != null){
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFile + "' not found in the classpath");
        }

        return properties.getProperty(key);
    }

}
