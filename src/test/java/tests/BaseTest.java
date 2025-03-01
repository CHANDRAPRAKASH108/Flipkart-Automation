package tests;

import constants.FrameworkConstant;
import driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ExcelUtils;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BaseTest {
    private static List<Map<String, String>> browserResult;

    static {
        browserResult = ExcelUtils.readExcelValue(FrameworkConstant.getTestRunnerSheet());
    }

    private String getBrowserForTest(String testName) {
        System.out.println(testName);
        for (Map<String, String> row : browserResult) {
            if (Objects.equals(row.get("testName").trim(), testName)) {
                System.out.println(row.get("browser"));
                return row.get("browser");
            }
        }
        return "chrome";
    }

    @BeforeMethod
    public void setup(Method method) {
        Driver.initDriver(getBrowserForTest(method.getName()));
    }

    @AfterMethod
    public void tearDown() throws MalformedURLException {
        Driver.quitDriver();
    }
}
