package tests.day13_testNGFramework;

import org.testng.annotations.Test;
import utilities.ConfigReader;

public class C03_ConfigReader {

    @Test
    public void test01(){

        System.out.println(ConfigReader.getProperty("amazonUrl")); // https://www.amazon.com

        System.out.println(ConfigReader.getProperty("wiseUrl"));
        // key yanlis yazilirsa, ConfigReader'daki properties objesi
        // yanlis yazilan key'i bulamaz ve null doner

        System.out.println(ConfigReader.getProperty("kullaniciAdiAhmet")); // veysel

        System.out.println(ConfigReader.getProperty("password")); // 12345
        System.out.println(ConfigReader.getProperty("browser"));
    }
}