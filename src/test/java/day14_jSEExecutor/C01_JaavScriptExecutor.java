package day14_jSEExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JaavScriptExecutor extends TestBase {

    @Test
    public void test01(){
        //wiseQuarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");
        // asagiya inerek software development engineer in test kursunda
        //Explore the course butonuna basin.
        WebElement exploreButton=driver.findElement(By.xpath("(//a[@class='elementskit-btn whitespace--normal'])[2]"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;
        //jse ile butona kadar scroll yapalim
        jse.executeScript("arguments[0].scrollIntoView();",exploreButton);
        //jse ile click yapalim

        jse.executeScript("arguments[0].click();",exploreButton);

        //jse ile alert olusturma

        jse.executeScript("alert(‘yasasinnnn’);",exploreButton);


    }

}
