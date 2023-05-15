package day09_switchingWindow_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsClass extends TestBase {

    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragME=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHereElement=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions= new Actions(driver);
        actions.dragAndDrop(dragME,dropHereElement).perform();
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedYaziEleemnti=driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String expectedYazi="Dropped!";
        String actualYazi=droppedYaziEleemnti.getText();
        Assert.assertEquals(expectedYazi,actualYazi);



    }
}
