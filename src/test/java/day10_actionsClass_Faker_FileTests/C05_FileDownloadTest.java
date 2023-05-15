package day10_actionsClass_Faker_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import javax.sound.midi.spi.SoundbankReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileDownloadTest extends TestBase {

    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. logo.png dosyasını indirelim
    //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
    @Test
    public void test01() throws InterruptedException {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. image.png dosyasını indirelim
        WebElement photoElement= driver.findElement(By.linkText("image.png"));
        photoElement.click();
        Thread.sleep(3000);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        //Dosyayi download klasorune indirecek

        String filePath="C:/Users/mahmu/Downloads/image.png";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

        //herkesib pc de farkli bir dosya hiyerarsisi oldugundan
        //herkesin dosya yolu birbirinden farkli olur.
        //dosya yolunu dinamik hale getirecegiz.

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));



    }
}
