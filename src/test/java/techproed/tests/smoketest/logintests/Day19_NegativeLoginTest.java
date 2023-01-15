package techproed.tests.smoketest.logintests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day19_NegativeLoginTest {

    HomePage homePage;
    LoginPage loginPage;
    Faker faker;


    @Test
    public void US100208_Negative_Login() throws IOException {
//        As customer, I should not be able to log in the application
        //going blue rental car home page

        //        https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//      Click on login button
        HomePage homePage= new HomePage();
        homePage.homePageLoginButton.click();

//        Type  john@doe.com into email input
        LoginPage loginPage = new LoginPage();
        loginPage.emailInput.sendKeys("fake@bluerentalcars.com");

//
//        Type  John.123 into password input
        loginPage.passwordInput.sendKeys("fakepass");
        ReusableMethods.waitFor(3);
//
//        Click on login submit button
        loginPage.loginSubmitButton.click();
        ReusableMethods.waitFor(3);

       // Error: User with email fake@bluerentalcars.com not found
        String errorMessage = loginPage.errorMessage_incorrectEmailPass.getText();
        Assert.assertEquals(errorMessage,"User with email fake@bluerentalcars.com not found");
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");

        Driver.closeDriver();
    }




    @Test
    public void invalidCredsTest() throws IOException {

        //        https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//      Click on login button
        HomePage homePage= new HomePage();
        homePage.homePageLoginButton.click();

//        Type  john@doe.com into email input
        LoginPage loginPage = new LoginPage();
        faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        loginPage.emailInput.sendKeys(fakeEmail);

//
//        Type  John.123 into password input
        loginPage.passwordInput.sendKeys(faker.internet().password(4,6));
        ReusableMethods.waitFor(3);
//
//        Click on login submit button
        loginPage.loginSubmitButton.click();
        ReusableMethods.waitFor(3);

        // Error: User with email fake@bluerentalcars.com not found
        String errorMessage = loginPage.errorMessage_incorrectEmailPass.getText();
        Assert.assertEquals(errorMessage,"User with email " +fakeEmail+ " not found");
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");

        Driver.closeDriver();



    }
}
