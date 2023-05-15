package day09_switchingWindow_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.LocalTime;
import java.util.Set;

public class C03_ActionsClass extends TestBase {

    @Test
    public void test01(){
        /*
        //x saniyelik bir sayac yapalim
        int x=3;
        LocalTime baslangic= LocalTime.now();
        int baslangicSaniye=baslangic.getSecond();
        int bitisSaniyesi=baslangicSaniye+x>60 ? baslangicSaniye+x-60 : baslangicSaniye+x;
        int saniyeKontrol=123;
        while(bitisSaniyesi!=saniyeKontrol){
            saniyeKontrol=LocalTime.now().getSecond();
        }
        System.out.println("baslangic saniyesi " + baslangicSaniye);
         */
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlan=driver.findElement(By.id("hot-spot"));
        Actions action= new Actions(driver);
        action.contextClick(ciziliAlan).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertyazisi="You selected a context menu";
        String actualAlertyazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertyazisi,actualAlertyazisi);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        //once yeni acilan windowun window handel alalim
        String ilkWindowWHD=driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        String ikinciWindowWHD="";
        Set<String> windowWHDSeti=driver.getWindowHandles();
        for (String eachWHD:windowWHDSeti
             ) {
            if (!eachWHD.equals(ilkWindowWHD)){
                ikinciWindowWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciWindowWHD);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String expectedYazi="Elemental Selenium";
        WebElement yaziElementi=driver.findElement(By.tagName("h1"));
        String actualYazi=yaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);




    }
}
