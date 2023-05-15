package day09_switchingWindow_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_SwtichingWindows extends TestBase {
    /*
      driver.switchTo().newWindow() kullanarak actigimiz
      window'a driver otomatik olarak gecer
      ANCAKKKKK....
      biz newWindow() method'unu kullanmadan
      bir link tikladigimizda yeni window aciliyorsa
      driver eski window'da kalir
      Yeni window'a driver'i gecirebilmek icin
      yeni window'un WindowHandleDegerine ihtiyacimiz vardir.
   */
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
    // “The Internet” olduğunu doğrulayın.
    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWHD=driver.getWindowHandle();
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openingWindowYaziElementi= driver.findElement(By.tagName("h3"));
        String expectedYazi="Opening a new window";
        String actualYazi= openingWindowYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        Set<String> whdegerleriSet=driver.getWindowHandles();
        String ikinciWindowWHD="";
        for (String eachWHD:whdegerleriSet
             ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciWindowWHD = eachWHD;
            }
        }
        // Artik acilan 2.window'un windowHandleDegerine sahibiz
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciWindowWHD);
        expectedTitle= "New Window";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newWindowyaziElementi= driver.findElement(By.tagName("h3"));
        String expectedYazi1 = "New Window";
        actualYazi = newWindowyaziElementi.getText();
        Assert.assertEquals(expectedYazi1,actualYazi);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        // “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWHD);
        expectedTitle="The Internet";
        actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }
}
