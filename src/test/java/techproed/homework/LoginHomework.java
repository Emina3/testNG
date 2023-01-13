package techproed.homework;

import org.testng.annotations.Test;
import techproed.pages.TestHomePage;
import techproed.pages.TestLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertTrue;

public class LoginHomework {
    //https://testcenter.techproeducation.com/index.php?page=form-authentication
    //    Login the application by using page object model

    /*
    Given
        Go to https://testcenter.techproeducation.com/index.php?page=form-authentication
     When
         Type "techproed" into username input
       And
           Type "SuperSecretPassword" into username input
        And
            Click login button
          Then
              Verify user signed in
     */

    @Test
    public void loginTest(){
//        Go to https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("test_login_url"));

//        Type "techproed" into username input

        TestLoginPage testLoginPage = new TestLoginPage();
        testLoginPage.usernameInput.sendKeys("techproed");

//        Type "SuperSecretPassword" into username input
        testLoginPage.passwordInput.sendKeys("SuperSecretPassword");


//        Click login button
          testLoginPage.submitButton.click();

//        Verify user signed in
        TestHomePage testHomePage = new TestHomePage();
   //     assertTrue(testHomePage.loginSuccessMessage.isDisplayed());
          ReusableMethods.verifyElementDisplayed(testHomePage.loginSuccessMessage);

    }
}
