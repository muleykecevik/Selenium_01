package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assert {
@Test
    public void test01(){

    /*
    Junit calistirilan test method(lar)indan kac tanesinin passed failed ya da ignore
    oldugunu otomatik olarak raporlar.

    eger Junit in test sonuclarini dogru olarak raporlamasini istiyorsak assert calssidnan
    hazir methodlar kullanarak test yapmaliyiz

     */
        //amazona gidip title AMAZON icerdigini test edin
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        String expectedTitle="AMAZON";
        String actualTitle=driver.getTitle();

       /* if (actualTitle.contains(expectedTitle)){
            System.out.println("title testi passed");
        } else{
            System.out.println("title testi failed");
        }

        */
    Assert.assertTrue(actualTitle.contains(expectedTitle));
        driver.close();
    }


}
