package techproed.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.MeddunaHomePage;
import techproed.pages.MeddunaLoginPage;
import techproed.pages.MeddunaPatientPage;
import techproed.utilities.*;

public class MeddunaPatient {
    //Admin can create patients

    /*
    Given
        Go to https://medunna.com/
     When
        Click on "user-icon"
     And
        Click on "Sign In" option(dropdown)
     And
        Enter username into "Username" input
     And
         Enter password into "Password" input
      And
         Click on "Remember me" check box
       And
         Click on "Sign in" submit button
       And
          Click on "Items&Titles" menu
       And
          Click on "Patient" option
       And
          Click on "Create a new patient" button
        And
          Enter firstname into "First Name" input
          Enter lastname into "Last Name" input
          Enter email into "Email" input
          Enter phone number into "Phone" input
        And
          Click on "Save" button

     */

    @DataProvider
    public Object[][] meddunaCredentials(){
        ExcelUtils excelUtils = new ExcelUtils("./src/test/java/resources/MedunnaCredentials.xlsx","medunna01");

        Object[][] arr = excelUtils.getDataArrayWithoutFirstRow();

 //       Object[][] arr = {
//                {"john_doe11","John.123","Merry","Terry","a@.com","1234567890"},
//                {"john_doe12","John.123","Merry","Terry","a@.com","1234567890"},
//                {"john_doe13","John.123","Merry","Terry","a@.com","1234567890"},
//                {"john_doe14","John.123","Merry","Terry","a@.com","1234567890"},
//                {"john_doe15","John.123","Merry","Terry","a@.com","1234567890"}
//        };
        return arr;

    }

    @Test(dataProvider = "meddunaCredentials",groups = "smoke test")
    public void createPatient(String username,String password,String patientFN,String patientLN,String patientEmail,String patientPhone){

//        Go to https://medunna.com/
        Driver.getDriver().get(ConfigReader.getProperty("medduna_url"));

//        Click on "user-icon"
        MeddunaHomePage meddunaHomePage = new MeddunaHomePage();
        meddunaHomePage.userIcon.click();
//        Click on "Sign In" option(dropdown)
        meddunaHomePage.signInOption.click();

//        Enter username into "Username" input
        MeddunaLoginPage meddunaLoginPage = new MeddunaLoginPage();
        meddunaLoginPage.usernameInput.sendKeys(username);

//        Enter password into "Password" input
        meddunaLoginPage.passwordInput.sendKeys(password);

//        Click on "Remember me" check box
        meddunaLoginPage.rememberMeCheckBox.click();

//        Click on "Sign in" submit button
        meddunaLoginPage.signInSubmitButton.click();

//        Click on "Items&Titles" menu
        meddunaHomePage.itemsAndTitlesMenu.click();

//        Click on "Patient" option
        meddunaHomePage.patientOption.click();

//        Click on "Create a new patient" button
        MeddunaPatientPage meddunaPatientPage = new MeddunaPatientPage();
        meddunaPatientPage.createNewPatientButton.click();

//        Enter firstname into "First Name" input
        meddunaPatientPage.patientFirstNameInput.sendKeys(patientFN);

//        Enter lastname into "Last Name" input
        meddunaPatientPage.patientLastNameInput.sendKeys(patientLN);

//        Enter email into "Email" input
        meddunaPatientPage.patientEmailInput.sendKeys(patientEmail);

//        Enter phone number into "Phone" input
        meddunaPatientPage.patientPhoneInput.sendKeys(patientPhone);

//        Click on "Save" button
      JSUtils.clickElementByJS(meddunaPatientPage.saveSubmitButton);

    //  Driver.closeDriver();
    }



    @AfterMethod
    public void closeDriver(){
        ReusableMethods.waitFor(2);
        Driver.closeDriver();
    }
}
