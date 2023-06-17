package day13_excelAutomation_Screenshot;

import org.apache.hc.core5.http.impl.io.IdentityOutputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void test01() throws IOException {
        String doyaYolu=System.getProperty("user.dir")+"/src/test/java/day12_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(doyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sheet= workbook.getSheet("Sayfa1");


        //4.hucreye yeni bir cell olusturalim
        sheet.getRow(0).createCell(4).setCellValue("Nufus");

        //2.satir nufus kolonuna 150000 yazdiralim
        sheet.getRow(1).createCell(4).setCellValue(150000);
        //10.satir kolonuna 250000 yazdiralim
        sheet.getRow(9).createCell(4).setCellValue(250000);
        //15.satir kolonuna 54000 yazdiralim
        sheet.getRow(14).createCell(4).setCellValue(54000);
        //dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(doyaYolu);
        workbook.write(fos);
        fis.close();
        fos.close();
        workbook.close();





    }
}
