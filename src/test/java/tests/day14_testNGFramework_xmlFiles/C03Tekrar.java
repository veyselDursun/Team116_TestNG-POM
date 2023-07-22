package tests.day14_testNGFramework_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03Tekrar {

    @Test

    public void test01(){
        // amazona gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // title'in best icermedigini test edin
        SoftAssert softAssert = new SoftAssert();
        String unexpectedIcerik = "best";
        String actualTitle = Driver.getDriver().getTitle();

        softAssert.assertFalse(actualTitle.contains(unexpectedIcerik));

        // url'in "https://www.amazon.com/" oldugunu test edin

        String expectedUrl = "https://www.amazon.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl);


        //Nutella aratin

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);


        // arama sonuclarinin Nutella icerdigini test edin

        String expectedUrunIcerik = "Nutella";
        String actualUrunIcerik = amazonPage.sonucYaziElementi.getText();
        softAssert.assertTrue(actualUrunIcerik.contains(expectedUrunIcerik));

        softAssert.assertAll();

        Driver.closeDriver();


    }
}
