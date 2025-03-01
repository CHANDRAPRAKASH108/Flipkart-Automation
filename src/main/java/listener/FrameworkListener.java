package listener;

import driver.Driver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FrameworkListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {

    }

    @Override
    public void onFinish(ISuite suite) {
        Driver.quitDriver();
    }

    @Override
    public void onTestStart(ITestResult result) {
        Driver.initDriver("chrome");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Driver.quitDriver();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Driver.quitDriver();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Driver.quitDriver();

    }
}
