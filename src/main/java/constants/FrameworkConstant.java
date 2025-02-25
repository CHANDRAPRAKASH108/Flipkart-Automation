package constants;

public final class FrameworkConstant {
    private FrameworkConstant(){}

    private static final String TESTDATA = "TESTDATA";

    private static final String CONFIG_FILE_PATH = System.getProperty("user.dir")+"/src/test/resources/config/config.properties";

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }
}
