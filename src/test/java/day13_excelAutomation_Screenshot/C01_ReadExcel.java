package day13_excelAutomation_Screenshot;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {
        //ulkeler deki 16.satirdaki
        // ulkenin turkce isminin barbados oldugunu test edin
        String dosyaYolu=System.getProperty("user.dir")+"/src/test/java/day12_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook=WorkbookFactory.create(fis);
        String actualIsim=workbook.getSheet("Sayfa1").getRow(15).getCell(2)
                .toString();
        String expectedIisim="Barbados";
        Assert.assertEquals(expectedIisim,actualIsim);

        //excelde benin diye bir ulke olup olmadigini kontrol edin
        int sonSatirIndex=workbook.getSheet("Sayfa1").getLastRowNum();
        boolean beninVarMi=false;
        for (int i = 1; i <=sonSatirIndex ; i++) {
            workbook.getSheet("Sayfa1").getRow(i).getCell(0)
                    .toString();
           if (actualIsim.equalsIgnoreCase("Benin")){
               beninVarMi=true;
               break;
           }

        }
        //Assert.assertTrue(beninVarMi);
        //sayfa2de kullanilan satir sayisinin 7 oldugunu test edin

        int kullanilanSatirSayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        int expectedSatirSayisi=8;
        Assert.assertEquals(expectedSatirSayisi,kullanilanSatirSayisi);

        //sayfa1deki tum ulke ve tum bilgileri bir map olarak kaydedin
        //ing isim key geriye kalanalr ise
        //birlestirilerek value olsun
        Sheet sheet=workbook.getSheet("Sayfa1");
        Map<String,String> ulkelerMap =new TreeMap<>();
        for (int i = 1; i <sonSatirIndex; i++) {
            String key=sheet.getRow(i).getCell(0).toString();
            String value= sheet.getRow(i).getCell(1).toString()+","+
                    sheet.getRow(i).getCell(2).toString()+","+
                    sheet.getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
        }
        System.out.println(ulkelerMap);

        //ismi netherlands olan ulke var mi kontrol edin

        Assert.assertTrue(ulkelerMap.containsKey("Netherlands"));


    }
}
