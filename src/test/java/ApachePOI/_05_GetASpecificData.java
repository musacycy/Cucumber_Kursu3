package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.*;

/**
 * Verilen Exceldeki password bilgisini bir metoda aracılığı bularak yazdırınız,
 * yani metoda "password" kelimesi gönderilecek, dönen değr password un kendisi olacak.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */
public class _05_GetASpecificData {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Kelime giriniz :");
        String str=br.readLine();
        String path="src/test/java/ApachePOI/resources/LoginData.xlsx";
        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        int sheetCount=workbook.getNumberOfSheets();
        System.out.println("sheet sayisi ="+sheetCount);
        Sheet sheet=workbook.getSheet("Login");
        int rowCount=sheet.getPhysicalNumberOfRows();

        for(int i=0;i<rowCount;i++){
            Row row=sheet.getRow(i);
            int cellCount=row.getPhysicalNumberOfCells();
            for (int j=0;j<cellCount;j++){

                Cell cell=row.getCell(j);
                if(cell.toString().equals(str)){

                    System.out.println("Sonuç ="+row.getCell(j+1));
                }

            }
            System.out.println();
        }
    }
}
