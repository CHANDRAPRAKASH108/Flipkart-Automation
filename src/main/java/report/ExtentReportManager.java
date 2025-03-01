package report;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReportManager {

    private ExtentReportManager() {
    }

    private static ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return extentTestThread.get();
    }

    static void setExtentTest(ExtentTest extentTest) {
        extentTestThread.set(extentTest);
    }

    static void unload() {
        extentTestThread.remove();
    }
}
