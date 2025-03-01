package constants;

public final class FrameworkConstant {
    private FrameworkConstant(){}

    private static final String TESTDATA = System.getProperty("user.dir")+"/src/test/resources/excel/testdata.xlsx";
    private static final String ADDTOCARTSHEET = "ADDTOCART";
    private static final String BOOKFLIGHTSHEET = "BOOKFLIGHT";
    private static final String TESTRUNNERSHEET = "TESTRUNNER";
    private static final String CONFIG_FILE_PATH = System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
    private static final String EXTENT_REPORT_PATH = System.getProperty("user.dir")+"/extent-test-output/";

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }
    public static String getExcelFilePath() {
        return TESTDATA;
    }
    public static String getAddToCartSheet() {return ADDTOCARTSHEET;}
    public static String getBookFlightSheet() {return BOOKFLIGHTSHEET;}
    public static String getTestRunnerSheet() {return TESTRUNNERSHEET;}

    public static String getExtentReportPath() {
        return EXTENT_REPORT_PATH;
    }
}
