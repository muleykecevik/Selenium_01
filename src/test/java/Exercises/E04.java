package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class E04 extends TestBase {
    //2- https://www.amazon.com sayfasina gidelim
    //3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    //4- aramanin gerceklestigini test edin

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        Actions action= new Actions(driver);
        action.click(searchBox).sendKeys("Samsung A71"+ Keys.ENTER).perform();
        Thread.sleep(5000);
        WebElement result= driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String actualResult=result.getText();
        String expected="Samsung A71";
        Assert.assertTrue(actualResult.contains(expected));
        searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        //driver.navigate().back();
        //searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        action.click(searchBox).keyDown(Keys.SHIFT).sendKeys("d").keyUp(Keys.SHIFT).sendKeys("olap").sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);
    }



}
