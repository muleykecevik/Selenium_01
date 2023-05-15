package Exercises;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class E05 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement name=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        Actions action= new Actions(driver);
        Faker fake=new Faker();
        String email=fake.internet().emailAddress();
        action.click(name).sendKeys(fake.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(fake.name().lastName()).sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(fake.internet().password()).
                  sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(fake.regexify("12")).sendKeys(Keys.TAB)
                .sendKeys("mart").sendKeys(Keys.TAB).sendKeys("1996").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).perform();
        Thread.sleep(5000);
        //4- Kaydol tusuna basalim
        action.sendKeys(Keys.ENTER).perform();


    }


}
