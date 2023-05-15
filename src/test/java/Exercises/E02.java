package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class E02 {
    //amazon.tr ye gidin
    //tum kategorileri secin ve bakim-kozmetik option tiklayin
    // Searcbox'a ruj yazin
    // Maybelline New York secin
    // Cikan sonuc sayisinin 76 oldugunu test edin
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com.tr/");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        WebElement dropDownMenu= driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDownMenu);
        select.selectByVisibleText("Kişisel Bakım ve Kozmetik");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("ruj"+ Keys.ENTER);
        driver.findElement(By.xpath("//*[text()='MAYBELLINE']")).click();
        WebElement sonuc= driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String sonuc1=sonuc.getText();
        String[] arr=sonuc1.split(" ");
        String sonucadedi= arr[0];
        sonucadedi= sonucadedi.replaceAll("\\D","");
        int actualSonucSayisi=Integer.parseInt(sonucadedi);
        int expected=20000;

        Assert.assertEquals(expected,actualSonucSayisi);


    }
}

