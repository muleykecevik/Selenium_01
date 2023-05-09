package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertion {
    WebDriver driver;
    @Test
    public void googleTest(){
        //1- Google anasayfaya gidip url in google içerip içermediğini test edin.
        System.out.println("google test");
        mahserin4Atlisi();
        driver.get("https://www.google.com");
        String expectedIcerik= "google";
        String actualURL=driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedIcerik));
        driver.close();

    }
    @Test
    public void wiseTest(){
        System.out.println("wise test");
        mahserin4Atlisi();
        driver.get("https://www.wisequarter.com");
        String expectedIcerik= "wisequarter";
        String actualURL=driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedIcerik));

        driver.close();

    }
    @Test
    public void amazonTest(){
        System.out.println("amazon test");
        mahserin4Atlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(amazonLogoElementi.isDisplayed());

        driver.close();

    }

    public void mahserin4Atlisi () {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
}
