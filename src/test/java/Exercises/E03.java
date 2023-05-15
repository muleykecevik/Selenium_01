package Exercises;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E03 extends TestBase {
    //3 test method’u olusturup asagidaki gorevi tamamlayin
    //1. Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    // - 1.alert’e tiklayin
    // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
    // - OK tusuna basip alert’i kapatin
    //2.Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    // - 2.alert’e tiklayalim
    // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
    //3.Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    // - 3.alert’e tiklayalim
    // - Cikan prompt ekranina “Abdullah” yazdiralim
    // - OK tusuna basarak alert’i kapatalim
    // - Cikan sonuc yazisinin Abdullah icerdigini test edelim

    @Test
    public void test01() throws InterruptedException {
        //1. Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        // - 1.alert’e tiklayin
        // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        // - OK tusuna basip alert’i kapatin

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alert= driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        Thread.sleep(2000);
        alert.click();
       String actualYazi= driver.switchTo().alert().getText();
       String expectedYazi="I am a JS Alert";
       Assert.assertEquals(expectedYazi,actualYazi);
       driver.switchTo().alert().accept();
    }
    @Test
    public void test02(){
        //2.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 2.alert’e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        driver.switchTo().alert().dismiss();
        WebElement cancelYazisiElement=driver.findElement(By.id("result"));
        String actualCancelYazisi=cancelYazisiElement.getText();
        String expectedYazi="You clicked: Cancel";
        Assert.assertEquals(expectedYazi,actualCancelYazisi);
    }
    @Test
    public void test03(){
        //3.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 3.alert’e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        // - Cikan prompt ekranina “Abdullah” yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        // - OK tusuna basarak alert’i kapatalim
        driver.switchTo().alert().accept();
        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedYazi="Abdullah";
        String actualYazi=driver.findElement(By.id("result")).getText();
        Assert.assertTrue(actualYazi.contains(expectedYazi));

}

}
