package day13_excelAutomation_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TumSayfaSS extends TestBase {

        //amazon ana sayfaya gidelim
        // Nutella aratalım
        // sonuçların nutella içerdiğini test edelim
        // Rapora eklenmek üzere tüm sayfanın ekran görüntüsünü alalım

        @Test
        public void test01 () throws IOException {
            // amazon anasayfaya gidelim
            driver.get("https://www.amazon.com");
            // Nutella aratalim
            WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
            aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
            // Sonuclarin Nutella icerdigini test edelim
            WebElement sonucElementi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
            String actualSonucYazisi= sonucElementi.getText();
            String expectedIcerik = "Nutella";
            Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
            // rapora eklenmek uzere, tum sayfanin ekran goruntusunu alalim
            TakesScreenshot tss = (TakesScreenshot) driver;
            File tumSayfaResim = new File("target/ekranResimleri/tumSayfaResim.png");
            File geciciResim = tss.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(geciciResim,tumSayfaResim);
            ReusableMethods.takeAScreenShot(driver);
        }
    }
