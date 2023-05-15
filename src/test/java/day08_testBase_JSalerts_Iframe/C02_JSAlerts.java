package day08_testBase_JSalerts_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClass;

public class C02_JSAlerts extends TestBaseBeforeClass {

    /*
    otomasyon yaparken iki tur allert ile karsilasabiliriz.
    1- html alerts: HTML kodlari ile olustulmus alertlerdir. html ler
    ile olusturuldugu icin inspect edilebilir. locate edilebilir
    driver ile kullanilabilir.
    2- JavaScript Alert: Inspect yapilamaz. Locate edilemez.
    Testlerimiz sirasinda JS alert ile karsilasirsak
    driver.swtichTo().alert() methodlarini kullanarak alert'e gecis yapabilir
    ve alert uzerinde OK,cancel,Alert yazisini alma getText() ve
    alert'e yazi yollama sendKeys() methodlarini kullanabiliriz.
     */

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
    public void test01(){
        //1. Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
       driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 1.alert’e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        String expected="I am a JS Alert";
        String actual= driver.switchTo().alert().getText();
        Assert.assertEquals(expected,actual);
        // - OK tusuna basip alert’i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void test02(){
        //2.Test
        // - https://the-internet.herokuapp.com/javascript_alerts
        // adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 2.alert’e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        // - Cancel’a basip, cikan sonuc yazisinin
        // “You clicked: Cancel” oldugunu test edin
        driver.switchTo().alert().dismiss();
        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedsonuc="You clicked: Cancel";
        Assert.assertEquals(expectedsonuc,actualResult);
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
        String expected="Abdullah";
        String actual=driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertTrue(actual.contains(expected));
    }
}
