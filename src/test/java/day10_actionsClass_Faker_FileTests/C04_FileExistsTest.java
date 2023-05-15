package day10_actionsClass_Faker_FileTests;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExistsTest {
    @Test
    public void test01(){
        //com.Team113JUnit projesinde deneme.txt dosyasinin varligin kontrol edin.

        String dosyaYolu="src/test/java/day10_actionsClass_Faker_FileTests/deneme.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

}
