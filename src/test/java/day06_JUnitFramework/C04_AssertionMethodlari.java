package day06_JUnitFramework;

import org.junit.Assert;
import org.junit.Test;

public class C04_AssertionMethodlari {

    @Test
    public void test01(){

        /*
        eger testin sonucunu olumlu bir cumle olarak sorduysa assert.true kullaniriz
        eger olumsuz bir cumle kullanilmissa assert.false tercih edilir.
         */
        int sayi1=20;
        int sayi2=10;
        int sayi3=30;

        //sayi1 in sayi2 den büyük oldugunu test edin

        Assert.assertTrue(sayi1 > sayi2); //passed

        //sayi1 in sayi 3 den büyük olmadigini test edin

        Assert.assertFalse(sayi1>sayi3);

        //sayi1 in sayi3 den kucuk oldugunu test edin

        Assert.assertTrue(sayi1<sayi3);
    }
}
