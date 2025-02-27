package constants;

public final class FrameworkConstant {
    private FrameworkConstant(){}

    private static final String TESTDATA = System.getProperty("user.dir")+"/src/test/resources/excel/testdata.xlsx";
    private static final String ADDTOCARTSHEET = "ADDTOCART";
    private static final String CONFIG_FILE_PATH = System.getProperty("user.dir")+"/src/test/resources/config/config.properties";

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }
    public static String getExcelFilePath() {
        return TESTDATA;
    }
    public static String getAddToCartSheet() {return ADDTOCARTSHEET;}


}
