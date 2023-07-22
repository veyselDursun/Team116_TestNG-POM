package tests.day14_testNGFramework_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02Tekrar {

    @Test

    public void test01(){
        // amazona gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // title'in best icermedigini test edin
        String unExpectedIcerik = "best";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertFalse(actualTitle.contains(unExpectedIcerik),"Title'da istenmeyen icerik var");

        // url'in "https://www.amazon.com/" oldugunu test edin
        String expectedUrl = "https://www.amazon.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Url beklenenden farkli");

        //Nutella aratin
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+Keys.ENTER);

        // arama sonuclarinin Nutella icerdigini test edin
        String expectedIcerik = "Nutella";
        String actualIcerik = amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik),"Arama onucu Nutella icermiyor");

        Driver.closeDriver();


    }
}
