package techproed.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;

/*
   USE @Listeners annotation to connect test classes and listeners
   techproed.utilities.Listeners.class ==> path of listeners utility
 */


@Listeners(techproed.utilities.Listeners.class)//connecting Listener class and this class
public class ListenersTest2 {

    @Test
    public void test1(){
        System.out.println("Test case 1 PASS");
        Assert.assertTrue(true);//PASS
    }

    @Test
    public void test2(){
        System.out.println("Test case 2 FAIL");
        assertTrue(false);//FAIL
    }

    @Test
    public void test3(){
        System.out.println("Test case  3 SKKIPED");
        throw new SkipException("SKIP THIS TEST CASE");//IF IT IS ALREADY SKIPPED IT WILL THROW THIS EXCEPTION
    }

    @Test
    public void test4(){
        System.out.println("Test case 4 No Such Element Exception");
        Driver.getDriver().get("https://techproeducation.com/");
        Driver.getDriver().findElement(By.id("abc"));//No Such Element Exception

    }


}
