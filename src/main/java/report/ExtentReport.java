package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameworkConstant;
import enums.CategoryType;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ExtentReport {

    private ExtentReport(){}

    private static ExtentReports extent;

    public static void initReport(){
        if (Objects.isNull(extent)){
            extent = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkConstant.getExtentReportPath());
            extent.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setTheme(Theme.DARK);
            extentSparkReporter.config().setDocumentTitle("Flipkart Automation");
            extentSparkReporter.config().setReportName("Flipkart Automation Report");
        }
    }

    public static void flushReport(){
        if (Objects.nonNull(extent)){
            extent.flush();
            ExtentReportManager.unload();
        }
    }

    public static void createTestCase(String testCaseName){
        ExtentReportManager.setExtentTest(extent.createTest(testCaseName));
    }

    public static void addAuthors(String[] authors){
        for (String author: authors){
            ExtentReportManager.getExtentTest().assignAuthor(author);
        }
    }

    public static void addCategories(CategoryType[] categories){
        for (CategoryType category: categories){
            ExtentReportManager.getExtentTest().assignCategory(category.toString());
        }
    }

}
