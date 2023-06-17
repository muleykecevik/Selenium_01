package day12_webTables_excelAutomation;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
import java.util.List;
public class C01_WebTables extends TestBase {
    //1."https://www.amazon.com" adresine gidin
    //2.Sayfanin en altina inin
    //3.Web table tum body’sini yazdirin
    //4.Web table’daki satir sayisinin 9 oldugunu test edin
    //5.Tum satirlari yazdirin
    //6. Web table’daki sutun sayisinin 13 olduğunu test edin
    //7. 5.sutunu yazdirin
    //8.Satir ve sutun sayisini parametre olarak alip,
    // hucredeki bilgiyi döndüren bir method olusturun
    @Test
    public void test01() throws InterruptedException {
        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions action = new Actions(driver);
        action.sendKeys(Keys.END).perform();
        //3.Web table tum body’sini yazdirin
        Thread.sleep(2000);
        WebElement allBodyElement=driver.findElement(By.tagName("tbody"));
        System.out.println(allBodyElement.getText());
      //tum body yi locate etmek body icinde gecen bir metnin varligini kabul
        // etmek icin kullanilabilir
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> rowElementsList=driver.findElements(By.xpath("//tbody/tr"));
        int expectedRowCount=9;
        int actualRowCount=rowElementsList.size();
        Assert.assertEquals(expectedRowCount,actualRowCount);
        //5.Tum satirlari yazdirin
        for (WebElement eachElement: rowElementsList
             ) {
            System.out.println(eachElement.getText());
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement>firstRowDatas=driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedSutun=13;
        int actualSutun=firstRowDatas.size();
        Assert.assertEquals(expectedSutun,actualSutun);
        //7. 5.sutunu yazdirin
        List<WebElement> besinciSutunElements=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement eachElement:besinciSutunElements
             ) {
            System.out.println(eachElement.getText());
        }
        //8.Satir ve sutun sayisini parametre olarak alip,
        System.out.println(dataGetir(3,5));
        // hucredeki bilgiyi döndüren bir method olusturun
    }
    private String dataGetir(int satirNo, int sutunNo) {
        ////tbody/tr/td[5][9]
        String dinamilXpath="tbody/tr[" +satirNo+ "]/td[" + sutunNo+"]";
        WebElement istenenDataElementi=driver.findElement(By.xpath(dinamilXpath));
        return istenenDataElementi.getText();
    }
}
