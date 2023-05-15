package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.image.Kernel;
import java.time.Duration;

public class P02 {

    /*
    Exercise-1:
    BeforeClass ile driver'i oluşturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.qooqle.com adresine gidin
    1-arama kutusuna "12 Angry Men” yaz ip, cikan sonuc şayisini yazdinin
    2-arama kutusuna "Vizontele” yaz ip, cikan sonuc şayisini yazdirin
    3-arama kutusuna "Saving Private Ryan” yaz4p, cikan sonuc şayisini yazdirin
    AfterClass ile kapatin.
     */
    static WebDriver driver;
    WebElement searchBox;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Before
    public void before(){
        driver.get("https://www.google.com");
        searchBox=driver.findElement(By.xpath("//*[@title='Ara']"));
    }
    @Test
    public void test01(){
        searchBox.sendKeys("12 Angry Men"+ Keys.ENTER);
        WebElement result = driver.findElement(By.id("result-stats"));
        System.out.println(result.getText());
    }
    @Test
    public void test02(){

        searchBox.sendKeys("Vizontele"+ Keys.ENTER);
        WebElement result = driver.findElement(By.id("result-stats"));
        System.out.println(result.getText());
    }
    @Test
    public void test03(){

        searchBox.sendKeys("Saving Private Ryan"+ Keys.ENTER);
        WebElement result = driver.findElement(By.id("result-stats"));
        System.out.println(result.getText());
    }




}
