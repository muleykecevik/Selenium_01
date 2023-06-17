package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E08 extends TestBase {
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke
    //(https://www.guru99.com/live-selenium-project.html) tıklayınız
    @Test
    public void test01() throws InterruptedException {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2) sayfadaki iframe sayısını bulunuz.
        WebElement iFrame1=driver.findElement(By.xpath("//div[@style='background-image: url(\"https://i.ytimg.com/vi_webp/RbSlW8jZFe8/maxresdefault.webp\");']"));
        Thread.sleep(2000);
        WebElement iFrame2=driver.findElement(By.id("a077aa5e"));
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(iFrame1);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız
        driver.switchTo().frame(iFrame2);
        driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).click();
        driver.switchTo().defaultContent();

    }
}
