package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class E06 extends TestBase {
    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. sample.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='USA.png']")).click();
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String file="C:/Users/mahmu/Downloads/USA.png";
        Assert.assertTrue(Files.exists(Paths.get(file)));

    }
}
