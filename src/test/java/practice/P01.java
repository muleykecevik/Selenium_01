package practice;

import org.junit.Test;
import utilities.TestBase;

public class P01 {
     /*
    @BeforeClass       // Sadece 1 kere çalışıyor
    @Before           //Her testten önce 1 kere çalışır
    @AfterClass      //Tüm testlerden sonra 1 kere çalışır
    @After          // her testten sonra 1 kere çalışır
    @Test          //Yapacağımız test kodlarının yer aldığı kısım
        */

    @Test
    public void test01(){
        System.out.println("test01");

    }

    @Test
    public void test02(){
        System.out.println("test02");

    }
    @Test
    public void test03(){
        System.out.println("test03");

    }
}
