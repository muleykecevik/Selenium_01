package day11_seleniumWaits_webTables;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies  extends TestBase {

    @Test
    public void test01(){
        //1- Amazon anasayfaya gidin
        //2- tum cookie’leri listeleyin
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        //8- tum cookie’leri silin ve silindigini test edin

        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet= driver.manage().getCookies();
        System.out.println(cookiesSet);
        int siraNo=1;
        for (Cookie eachCookie: cookiesSet) {
            System.out.println(siraNo+ "-------" + eachCookie);
            siraNo++;

        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedCookiecount=5;
        int actualCookieCount= cookiesSet.size();
        Assert.assertTrue(actualCookieCount>expectedCookiecount);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue= driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue="USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie myFavCookie=new Cookie("myFavCookie","withChocolate");
        driver.manage().addCookie(myFavCookie);
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        cookiesSet= driver.manage().getCookies();
        String favCookieValue="";
        siraNo=1;
        for (Cookie eachCookie: cookiesSet) {
            System.out.println(siraNo+ "-------" + eachCookie);
            if (eachCookie.getName().equals("myFavCookie"))
                favCookieValue=eachCookie.getValue();
            siraNo++;
        }
        expectedCookieValue="withChocolate";
        Assert.assertEquals(expectedCookieValue,favCookieValue);
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        siraNo=1;
        cookiesSet= driver.manage().getCookies();
        String flag="there is no a cookie name with skin";
        for (Cookie eachCookie: cookiesSet) {
            System.out.println(siraNo+ "-------" + eachCookie);
            if (eachCookie.getName().equals("skin")){
                flag="one cookie found name with skin";
            }
            siraNo++;
        }
        Assert.assertTrue(flag.equals("there is no a cookie name with skin"));
        //8- tum cookie’leri silin ve silindigini test edin
        Assert.assertEquals(cookiesSet.size(),0);
    }
}
