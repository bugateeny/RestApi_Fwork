package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {
    static File  file = new File("src/main/resources/Config.properties");
    static FileInputStream fis;
    static Properties prop = new Properties();

    public static String getSwaggerPage() throws Exception {
        fis = new FileInputStream(file);
        prop.load(fis);
        return prop.getProperty("SwaggerURL");

    }
}
