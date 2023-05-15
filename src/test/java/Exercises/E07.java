package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E07 extends TestBase {
    @Test
    public void test01(){
        ////https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        ////chooseFile butonunu kullanarak
        WebElement chooseFileButton=driver.findElement(By.id("file-upload"));
       // chooseFileButton.click();
        //// projemizdeki deneme.txt dosyasini secelim.
        String herkesFarkli=System.getProperty("user.dir");
        String herkesAyni="/src/test/java/Exercises/muleyke.txt";
        String dosyaYolu=herkesFarkli+herkesAyni;
        chooseFileButton.sendKeys(dosyaYolu);
        ////Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        ////"File Uploaded!" textinin goruntulendigini test edelim.
        WebElement fileuploaded=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileuploaded.isDisplayed());

    }
}
