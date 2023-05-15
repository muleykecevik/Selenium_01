package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
    // ilgili kurulumlari tamamlayalim
// Kullanici https://www.google.com adresine gider
// Çıkıyorsa Kullanici cookies i kabul eder
// Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
// Para birimlerinin karsilastirmasini alin
// Karsilastirilacak olan para biriminin 1.5 den kUCUk oldygu test edilir
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        // Kullanici https://www.google.com adresine gider
           driver.get("https://www.google.com");
        // Çıkıyorsa Kullanici cookies i kabul eder
        // Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer

        // Para birimlerinin karsilastirmasini alin
        // Karsilastirilacak olan para biriminin 1.5 den kUCUk oldygu test edilir

    }
}
