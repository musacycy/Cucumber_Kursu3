package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/resources/ApacheExcel2.xlsx";
        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        int sheetCount=workbook.getNumberOfSheets();
        System.out.println("sheet sayisi ="+sheetCount);
        Sheet sheet=workbook.getSheet("Sheet1");
        int rowCount=sheet.getPhysicalNumberOfRows();

        for(int i=0;i<rowCount;i++){
            Row row=sheet.getRow(i);
            int cellCount=row.getPhysicalNumberOfCells();
            for (int j=0;j<cellCount;j++){

                Cell cell=row.getCell(j);
                System.out.print(cell+" ");

            }
            System.out.println();
        }

    }
}
