package report;

import com.aventstack.extentreports.MediaEntityBuilder;
import driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ELKUtils;

public class ExtentLogger {
    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentReportManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
    }

    public static void fail(String message) {
        ExtentReportManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
    }

    public static void skip(String message) {
        ExtentReportManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
    }


    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
