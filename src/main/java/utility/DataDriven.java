package utility;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataDriven {

    @DataProvider(name = "LoginDetails")
    public Object[][] getData () throws IOException {
        String sheetPath = "C:\\Users\\Administrator\\IdeaProjects\\FaceBookDataDriven\\src\\test\\resources\\Sheet.xlsx";

        Object data[][] = testData(sheetPath,"Sheet1");
        return data;
    }


    public Object[][] testData(String sheetPath,String sheetName)  {

        //String projectPath = System.getProperty("user.dir");
        ReadExcelFile excel = new ReadExcelFile(sheetPath,sheetName);
        int rowCount = ReadExcelFile.getRowCount();
        int colCount = ReadExcelFile.getColCount();


        //creating 2 dimentional object array
        Object data[][] = new Object[rowCount-1][colCount];

        for(int i=1;i<rowCount;i++){
            for (int j=0;j<colCount;j++){
                String cellData = ReadExcelFile.getCellData(i,j);
                //System.out.println(cellData+"|" );
                data[i-1][j] = cellData;
            }
            System.out.println();
        }
        return data;

    }

}
