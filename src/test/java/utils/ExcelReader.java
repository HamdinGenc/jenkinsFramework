package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    static Workbook book;
    static Sheet sheet;


    //to open Excel file
    public static void openExcel(String filePath) {

        try {
            FileInputStream fis = new FileInputStream(filePath);
            book = new XSSFWorkbook(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    // this method is going to open the sheet in Excel file
    public static void getSheet(String sheetName) {
        sheet = book.getSheet(sheetName);

    }

    // it will return total number of rows available in the worksheet
    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();

    }

    //it will return the total number of columns in every row
    public static int getColsCount(int rowIndex) {
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }


    //it will return the data from cell in string format
    public static String getCellData(int rowIndex, int colIndex) {
        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }

    public static List<Map<String, String>> excelIntoMap(String filePath, String SheetName) {

        openExcel(filePath);
        getSheet(SheetName);

        List<Map<String, String>> ListData = new ArrayList<>();

        //outer loop
        for (int row = 1; row < getRowCount(); row++) {

            //creating a map for every row
            Map<String,String> map=new LinkedHashMap<>();
         for (int col=0;col<getColsCount(row);col++){

         map.put(getCellData(0,col),getCellData(row,col));
         }
         ListData.add(map);
        }
  return ListData;
    }


    }




