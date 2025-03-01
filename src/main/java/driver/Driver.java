package driver;

import enums.ConfigProperties;
import exceptions.BrowserInvocationFailedException;
import org.openqa.selenium.WebDriver;
import utils.PropertyReaderUtils;

import java.net.MalformedURLException;
import java.util.Objects;

public class Driver {

    private Driver(){

    }

    public static void initDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())){
            try{
                WebDriver webDriver = DriverFactory.getDriver(browser);
                DriverManager.setDriver(webDriver);
            }catch (MalformedURLException e){
                throw new BrowserInvocationFailedException(e.getMessage());
            }
            DriverManager.getDriver().get(PropertyReaderUtils.getValue(ConfigProperties.URL));
        }
    }

    public static void quitDriver(){
        if (Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}

