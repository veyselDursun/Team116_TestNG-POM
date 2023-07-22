package tests.day13_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06Tekrar {

    @Test

    public void test01(){
        //1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //2- login linkine basin
        QdPage qd = new QdPage();
        qd.ilkLoginLinki.click();

        // 3- Kullanici email'i olarak valid email girin
        qd.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));

        // 4- Kullanici sifresi olarak valid sifre girin
        qd.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        // 5- Login butonuna basarak login olun
        qd.loginButonu.click();

       // 6- Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(qd.basariliGirisKontrolElementi.isDisplayed());

        Driver.closeDriver();
    }

}
