package listener;

import enums.ConfigProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.PropertyReaderUtils;

public class RetryFailingTests implements IRetryAnalyzer {

    private int testCount = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        int maxRetryCount = Integer.parseInt(PropertyReaderUtils.getValue(ConfigProperties.MAXRETRYCOUNT));
        boolean shouldRetry = Boolean.parseBoolean(PropertyReaderUtils.getValue(ConfigProperties.RETRYTEST));

        if (testCount < maxRetryCount && shouldRetry) {
            testCount++;
            return true;
        }
        return false;
    }
}
