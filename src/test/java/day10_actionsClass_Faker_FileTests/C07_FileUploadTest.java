package day10_actionsClass_Faker_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FileUploadTest  extends TestBase {
    @Test
    public void test01(){

        /*
        driver ile gitgigimiz bir wweb sayfasidna pc deki
        bir dosyayi upload etmek istersek, pc deki klasore erişmek gerekir
        selenium webdriver pcdeki dosyalara erişeemz
        bunun yerien 3 adımlık işlem yaaparız
        1-chose file butonunu lcoate et
        22- pc dem yuklemek istedigimiz dosyanın mumkunse dinamik dosya yolunu
        olusturulaım
        3- chosebutonu.send  keys dosya yolu ile dosya yolunu siteye gödnerelim
         */
        ////https://the-internet.herokuapp.com/upload adresine gidelim
        ////chooseFile butonunu kullanarak
        //// projemizdeki deneme.txt dosyasini secelim.
        ////Upload butonuna basalim.
        ////"File Uploaded!" textinin goruntulendigini test edelim.

        ////https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        ////chooseFile butonunu kullanarak
        WebElement chooseButton= driver.findElement(By.id("file-upload"));

        String herkesteFarkli=System.getProperty("user.dir");
        String herkesteAyni="/src/test/java/day10_actionsClass_Faker_FileTests/deneme.txt";
        String filePath=herkesteFarkli+herkesteAyni;
        chooseButton.sendKeys(filePath);
        //// projemizdeki deneme.txt dosyasini secelim.
        ////Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        ////"File Uploaded!" textinin goruntulendigini test edelim.
        WebElement fileUplouded=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUplouded.isDisplayed());









    }
}
