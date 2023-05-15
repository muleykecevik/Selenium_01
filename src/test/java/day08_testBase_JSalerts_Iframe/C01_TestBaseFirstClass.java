package day08_testBase_JSalerts_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_TestBaseFirstClass extends TestBase {

    @Test
    public void test01(){
        //amazona git,

        driver.get("https://www.amazon.com");
        //nutella ara

        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        //arama sonuclarinin nutella icerdigini test edelim
        String expectedresult= "Nutella";
        String actualResult=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(actualResult.contains(expectedresult));

    }
}
