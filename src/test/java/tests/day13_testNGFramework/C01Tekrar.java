package tests.day13_testNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01Tekrar {

    @Test

    public void test01(){
        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Nutella icin arama yapin
        // Arama kutusunun locator'ina ihtiyacimiz var
        // locator'larimiz artik pages class'larinda
        // Locator'lar static olmadigi icin obje olusturarak kullanabiliriz
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin Nutella icerdigini test edin

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        // Sayfayi kapatin

        ReusableMethods.bekle(3);
        Driver.closeDriver();


    }

}


