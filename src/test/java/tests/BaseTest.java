package tests;

import constants.FrameworkConstant;
import driver.Driver;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ExcelUtils;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
@Log4j2
public class BaseTest {

    protected final Logger logger = LogManager.getLogger(getClass());

    @BeforeMethod
    public void setup(Object[] data) {
        logger.log(Level.ALL, "Started browser setup for the test ");
        Map<String, String> methodRef = (Map<String, String>) data[0];
        System.out.println("a"+methodRef.get("browser")+"a");
        Driver.initDriver(methodRef.get("browser"));
    }

    @AfterMethod
    public void tearDown() throws MalformedURLException {
        Driver.quitDriver();
    }
}
