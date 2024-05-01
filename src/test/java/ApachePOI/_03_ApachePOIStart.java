package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {
        //Dosyanın yolu alındı
        String path="src/test/java/ApachePOI/resources/ApacheExcel2.xlsx";
        //böylece program ile dosya arasındaki bağlantı oluştu
        FileInputStream dosyaOkumaBaglantisi=new FileInputStream(path);

        //Dosya okuma işlemcisi üzerinden çalışma kitabını alıyorum
        //hafızada workbooku alıp oluşturdu
        Workbook calismaKitabi= WorkbookFactory.create(dosyaOkumaBaglantisi);

        //istediğim sayfayı alıyoruz
        Sheet calismaSayfasi=calismaKitabi.getSheet("Sheet1");

        //istenilen satiri alıyorum
        Row satir=calismaSayfasi.getRow(0);
        //istenilen hücreyi alıyorum
        Cell hucre=satir.getCell(0);

        System.out.println("hucre ="+hucre);
    }
}
