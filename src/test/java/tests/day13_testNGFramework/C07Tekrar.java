package tests.day13_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C07Tekrar {

    //1- https://www.qualitydemy.com/ anasayfasina gidin
    //2- login linkine basin
    //3- 3 farkli test method’u olusturun.
    //	- gecerli username, gecersiz password
    //	- gecersiz username, gecerli password
    //	- gecersiz username, gecersiz password.
    //4- Login butonuna basarak login olun
    //5- Basarili olarak giris yapilamadigini test edin

    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QdPage qdPage = new QdPage();

        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isDisplayed());
        Driver.closeDriver();

    }
    @Test
    public void test02(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QdPage qdPage = new QdPage();

        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isDisplayed());
        Driver.closeDriver();

    }
    @Test
    public void test03(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QdPage qdPage = new QdPage();

        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isDisplayed());
        Driver.closeDriver();

    }
}
