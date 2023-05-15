package day10_actionsClass_Faker_FileTests;

import org.apache.hc.core5.http.nio.support.AbstractServerExchangeHandler;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_DosyaYolunuDinamikYapma {
    @Test
    public void test01(){
        //herkesib pc de farkli bir dosya hiyerarsisi oldugundan
        //herkesin dosya yolu birbirinden farkli olur.
        //dosya yolunu dinamik hale getirecegiz.

        System.out.println(System.getProperty("user.dir"));
        //projenin dosya yolunu verir
        System.out.println(System.getProperty("user.home"));

        //downloads a indirdigimiz dosyanin dosya yolunu ikiye bolecegiz
        //"C:/Users/mahmu                              /Downloads/image.png";
        //ilk kismi System.getproperty("user.home")
        String dosyaYoluDegisenKisim=System.getProperty("user.home");
        String dosyayoluHerkesteAyniKisim="/Downloads/image.png";
        String dosyaYolu=dosyaYoluDegisenKisim+dosyayoluHerkesteAyniKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //ayni islemi projedeki deneme.txt iccin yapalim

        dosyaYoluDegisenKisim=System.getProperty("user.dir");
        dosyayoluHerkesteAyniKisim="/src/test/java/day10_actionsClass_Faker_FileTests/deneme.txt";
        dosyaYolu=dosyaYoluDegisenKisim+dosyayoluHerkesteAyniKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
