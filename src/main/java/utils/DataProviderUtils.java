package utils;

import constants.FrameworkConstant;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.Map;

public class DataProviderUtils {
    private DataProviderUtils() {
    }

    @DataProvider(parallel = true)
    public static Object[][] getAddToCartData() {
        List<Map<String, String>> excelResult = ExcelUtils.readExcelValue(FrameworkConstant.getAddToCartSheet());
        Object[][] data = new Object[excelResult.size()][1];
        for (int i = 0; i < excelResult.size(); i++) {
            data[i][0] = excelResult.get(i);
        }
        return data;
    }
}
