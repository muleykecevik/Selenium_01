package day09_switchingWindow_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions extends TestBase {
    @Test
    public void test01(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun
        // acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions= new Actions(driver);
        WebElement acountListElementi=driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        actions.moveToElement(acountListElementi).perform();
        WebElement createListElement=driver.findElement(By.xpath("//*[text()='Create a List']"));


        //3- “Create a list” butonuna basin
        createListElement.click();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String expectedYazi="Your Lists";
        String actualYazi=driver.findElement(By.xpath("//div[@role='heading']")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }

}
