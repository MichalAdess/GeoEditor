package infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigManager {

    private Properties properties = new Properties();
    private static ConfigManager config;

    private ConfigManager() {
//        this.loadProperties();
        try {
            this.properties.load(new InputStreamReader(new FileInputStream(new File("environment.properties")), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigManager configs() {
        if (config == null) {
            config = new ConfigManager();
        }
        return config;
    }

//    private void loadProperties(){
//        try {
//            this.properties.load(new InputStreamReader(new FileInputStream(new File("environment.properties")), StandardCharsets.UTF_8));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public String getProperty(Props prop) {
        String property = this.properties.getProperty(prop.getValue());
        return property == null ? "" : property;
    }

    public void setProperty(Props prop, String value) {
        this.properties.setProperty(prop.getValue(), value);
    }


    public enum Props {

        BROWSER_TYPE("browser.type"),
        APP_URL("app.url")
        ;

        private String prop;

        Props(String prop) {
            this.prop = prop;
        }

        public String getValue() {
            return prop;
        }
    }

}
