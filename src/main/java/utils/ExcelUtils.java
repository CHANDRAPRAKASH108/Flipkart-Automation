package utils;

import constants.FrameworkConstant;
import exceptions.ErrorWhileReadingExcelException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {
    private ExcelUtils(){}

    public static List<Map<String, String>> readExcelValue(String sheetName){
        List<Map<String, String>> mapList = new ArrayList<>();

        try (FileInputStream fs = new FileInputStream(FrameworkConstant.getExcelFilePath()); XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fs)){
            XSSFSheet sheet = xssfWorkbook.getSheet(sheetName);
            Map<String, String> map;
            for (int i=1; i<=sheet.getLastRowNum(); i++){
                map = new HashMap<>();
                for (int j=0; j< sheet.getRow(0).getLastCellNum(); j++){
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                mapList.add(map);
            }
        }catch (IOException e){
            throw new ErrorWhileReadingExcelException("Error while reading the sheet "+sheetName+ " from excel file "+e);
        }
        return mapList;
    }
}
