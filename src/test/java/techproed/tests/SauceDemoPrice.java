package techproed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.SauceDemoHomePage;
import techproed.pages.SauceDemoProductsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertEquals;

public class SauceDemoPrice {

    /*
  Given
    Go to  https://www.saucedemo.com/
  When
    Enter the username  as "standard_user"
  And
    Enter the password as "secret_sauce"
  And
    Click on login button
  Then
    Assert that total price of all products is 129.94 dollars
  And
    Flash each web element you used
   */


    @Test(groups = "smoke-test")
    public void totalPriceTest(){

//        Go to  https://www.saucedemo.com/
        Driver.getDriver().get(ConfigReader.getProperty("sauce_demo_url"));
//
//        Enter the username  as "standard_user"
         SauceDemoHomePage sauceDemoHomePage=new SauceDemoHomePage();
         ReusableMethods.waitFor(2);
        JSUtils.flash(sauceDemoHomePage.usernameInput);
         sauceDemoHomePage.usernameInput.sendKeys(ConfigReader.getProperty("sauce_demo_username"));

//        Enter the password as "secret_sauce"
        JSUtils.flash(sauceDemoHomePage.passwordInput);
        sauceDemoHomePage.passwordInput.sendKeys(ConfigReader.getProperty("sauce_demo_password"));
//
//        Click on login button
        JSUtils.flash(sauceDemoHomePage.loginButton);
        sauceDemoHomePage.loginButton.click();
//
//        Assert that total price of all products is 129.94 dollars


       SauceDemoProductsPage sauceDemoProductsPage = new SauceDemoProductsPage();
        double sum = 0;
       for(WebElement w : sauceDemoProductsPage.pricesList){
           JSUtils.flash(w);
           sum+=Double.valueOf(w.getText().replaceAll("\\$",""));
       }
        System.out.println(sum);

       assertEquals(129.94,sum);
//
//        Flash each web element you used

     Driver.closeDriver();
    }

//    @AfterMethod
//    public void closeDriver(){
//        ReusableMethods.waitFor(2);
//        Driver.closeDriver();
//    }
}
