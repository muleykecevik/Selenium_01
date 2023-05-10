package day07_JUnit_dropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButtons {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    // a. Verilen web sayfasına gidin.
    //     https://facebook.com
    // b. Cookies’i kabul edin
    // c. Create an account buton’una basin
    // d. Radio button elementlerini locate edin ve size uygun olani secin
    // e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
WebDriver driver;
    @Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.manage().window().maximize();
}
    @After
    public void tearDown(){
        //driver.close();
}
    @Test
    public void radioButtonTest(){

        //     https://facebook.com

        driver.get("https://facebook.com");

        // c. Create an account buton’una basin
        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
        // d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement femaleButton=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement maleButton=driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement otherButton=driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
        // e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        femaleButton.click();
        Assert.assertTrue(femaleButton.isSelected());
        Assert.assertFalse(maleButton.isSelected());
        Assert.assertFalse(otherButton.isSelected());
    }


}
