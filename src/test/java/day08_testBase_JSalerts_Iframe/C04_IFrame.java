package day08_testBase_JSalerts_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_IFrame extends TestBase {
    // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    // 2 ) Bir metod olusturun: iframeTest
    //    - “An IFrame containing….” textinin erisilebilir
    //    oldugunu test edin ve  konsolda yazdirin.
    //    - Text Box’a “Merhaba Dunya!” yazin.
    //    - TextBox’in altinda bulunan “Elemental Selenium” linkini
    //    textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
    @Test
    public void test01(){
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        WebElement iFrameElement=driver.findElement(By.tagName("h3"));
        //    - “An IFrame containing….” textinin erisilebilir
        Assert.assertTrue(iFrameElement.isDisplayed());
        //    oldugunu test edin ve  konsolda yazdirin.
        System.out.println(iFrameElement.getText());
        //    - Text Box’a “Merhaba Dunya!” yazin.
        WebElement frameElementi= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);
        WebElement textBoxElement=driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBoxElement.clear();
        textBoxElement.sendKeys("Merhaba Dunya!");
        //    - TextBox’in altinda bulunan “Elemental Selenium” linkini
        //    textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().parentFrame();
        WebElement elementalSeleniumLink=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSeleniumLink.isDisplayed());
        System.out.println(elementalSeleniumLink.getText());
    }


}
