package tests.day13_testNGFramework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02Tekrar {

    @Test
    public void test01(){

        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin

        Faker faker = new Faker();
        FacebookPage facebookPage = new FacebookPage();

        facebookPage.cookiesButton.click();

        facebookPage.emailKutuElementi.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutuElementi.sendKeys(faker.internet().password());

        facebookPage.girisYapButonu.click();

        //4- Basarili giris yapilamadigini test edin

        Assert.assertTrue(facebookPage.basarisizGirisyaziElementi.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.closeDriver();



    }
}


