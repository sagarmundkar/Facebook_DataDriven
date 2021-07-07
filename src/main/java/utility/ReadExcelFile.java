package utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {
    static String projectpath;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    String Sheepath;
    File file;


    //creating constructor
    public ReadExcelFile(String sheetPath, String sheetName)  {
        this.Sheepath = sheetPath;
        try {
            projectpath = System.getProperty("user.dir");
            File file = new File(Sheepath);
            if(!file.exists()){
                throw  new FileNotFoundException("File not Found");
            }
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            sheet= workbook.getSheet(sheetName);

        }catch (IOException | FileNotFoundException e){
            e.printStackTrace();
        }

    }


    public static int getRowCount() {
        int rowCount=0;
        try {
            //get row count
            rowCount = sheet.getPhysicalNumberOfRows();
            // System.out.println("Number of row count:"+rowCount);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return rowCount;
    }

    public static int getColCount() {
        int colCount =0;
        try {
            //get row count
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            //System.out.println("Number of column count:"+colCount);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return colCount;
    }

    public static String getCellData(int rowNum, int colNum) {
        String cellData = null;
        try {
            //Get the row value
            cellData = sheet.getRow(rowNum).getCell(colNum).toString();
            //System.out.println(cellData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellData;
    }


}
