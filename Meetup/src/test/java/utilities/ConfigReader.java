package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    // we need to load our configuration.properties file into properties variable

    static {
        // first of all, we need to provide a path to our properties file
        try {
            String path = "src//test//resources//configuration.properties";

            // to read from the file
            FileInputStream inputStream = new FileInputStream(path);

            // now we need to load into the properties variable
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key).trim();

    }

}
