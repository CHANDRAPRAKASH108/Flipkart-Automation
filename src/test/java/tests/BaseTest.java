package tests;

import Driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest {

    @BeforeMethod
    public void setup() throws MalformedURLException {
        Driver.initDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws MalformedURLException {
        Driver.quitDriver();
    }
}
