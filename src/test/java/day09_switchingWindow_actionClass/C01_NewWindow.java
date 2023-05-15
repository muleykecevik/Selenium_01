package day09_switchingWindow_actionClass;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_NewWindow extends TestBase {
    @Test
    public void test01(){

        /*
        Eger driver.switchTo().newWindow() kullanilirsa
        driver otomatik olarak acilan yeni sayfaya gecer
        eger gorevimizde yeni window'a gittik'ten sonra
        window'lar arasi gecis islemi varsa
        uzerinde calistigimiz window'larin
        windowHandleDegerlerini alip kaydetmekte fayda var
     */
        // gerekli ayarlamalari yapip
       // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaWHD=driver.getWindowHandle();
       // title'in amazon kelimesi icerdigini test edin
        String expectedTitle="Amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
       // yeni bir tab acarak wisequarter anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String ikinciSayfaWHD=driver.getWindowHandle();
      // url'in wisequarter icerdigini test edin
        String expectedUrl= "wisequarter";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
      // tekrar amazonun acik oldugu sayfaya gecin ve URL in amazon icerdgini test edin
        driver.switchTo().window(ilkSayfaWHD);
        expectedUrl= "amazon";
        actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }

}
