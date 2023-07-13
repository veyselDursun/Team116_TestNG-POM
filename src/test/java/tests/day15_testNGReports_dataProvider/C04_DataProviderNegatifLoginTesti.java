package tests.day15_testNGReports_dataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C04_DataProviderNegatifLoginTesti extends TestBaseRapor {

    @DataProvider
    public static Object[][] kullaniciListesi() {
        String [][] kullaniciIsimSifreleri = {{"Veysel","12345"},{"Ahmet","345"},{"Veli","898"}};


        return kullaniciIsimSifreleri;
    }

    @Test(dataProvider = "kullaniciListesi")

    public void cokluNegatifLoginTesti(String kullaniciAdi, String password){
        extentTest=extentReports.createTest("DataProvider","Coklu negatif login");

        // Qualitydemy anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("Kullanici qualitydemy anasayfaya gider");

        // liste olarak verilen kullanici adi ve sifreleri ile
        // giris yapilamadigini test edin
        QdPage qdPage = new QdPage();

        // ilk login linkine tiklayin
        qdPage.ilkLoginLinki.click();

        // kullanici adi ve sifresini yazip giris yapmayi deneyin
        qdPage.emailKutusu.sendKeys(kullaniciAdi);
        qdPage.passwordKutusu.sendKeys(password);
        qdPage.loginButonu.click();
        extentTest.info("verilen  "+kullaniciAdi+" ve sifreyi yazip login butonuna basar");


    // giris yapilamadigini test edin
        Assert.assertTrue(qdPage.emailKutusu.isDisplayed());
        extentTest.pass("Giris yapilamadigini test eder");

    // sayfayi kapatin

        Driver.closeDriver();
        extentTest.info("sayfayi kapatir");


    }
}
