package driver;

import constants.FrameworkConstant;
import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ExcelUtils;
import utils.PropertyReaderUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser) throws MalformedURLException {
        WebDriver driver = null;
        String runMode = PropertyReaderUtils.getValue(ConfigProperties.RUNMODE);
        if (browser.equalsIgnoreCase("chrome")) {
            if (runMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName("chrome");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("edge")) {
            if (runMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName("MicrosoftEdge");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
            } else {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (runMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName("firefox");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }

        return driver;
    }
}
