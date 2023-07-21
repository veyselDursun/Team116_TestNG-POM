package tests.Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class P01_TestNotation {

    @Test
    public void ahmet(){
        System.out.println("Ahmet");
    }

    @Test (priority = -10)                             //@Ignore
    public void sevda(){
        System.out.println("Sevda");
    }

    @Test (priority = 30)
    public void esat (){
        System.out.println("Esat");

    }

    @Test
    public void yusuf(){
        System.out.println("Yusuf");
    }

    @Test                                        //(enabled = false)
    public void ilknur(){
        System.out.println("Ilknur");
    }

    @Test (dependsOnMethods = "sevda")        //sevda calisirsa calissin
    public void murat(){
        System.out.println("Murat Metin");
    }

}