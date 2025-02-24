package utils;

import constants.FrameworkConstant;
import enums.ConfigProperties;
import exceptions.PropertyKeyNullException;
import exceptions.PropertyNotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertyReaderUtils {
    private PropertyReaderUtils(){};

    private static Properties properties;

    static {
        try(FileInputStream file = new FileInputStream(FrameworkConstant.getConfigFilePath())) {
            properties = new Properties();
            properties.load(file);
        }catch(IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String getValue(ConfigProperties key){
        String value;
        if (Objects.isNull(key)){
            throw new PropertyKeyNullException("Property name cannot be null");
        }
        value = properties.getProperty(key.name().toLowerCase());
        if (value.isEmpty()){
            throw new PropertyNotFoundException("Property with"+key+" not found in config.properties file");
        }
        return value;
    }

}
