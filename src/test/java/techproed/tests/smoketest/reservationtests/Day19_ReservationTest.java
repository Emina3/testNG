package techproed.tests.smoketest.reservationtests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Day19_ReservationTest {

    /*
    Name:
User should be able to reserve a car
Description:
User should be able to reserve a car as customer service profile
Acceptance Criteria:
Given user is on the home page
And select a car
And enter pick up field
And enter drop off field
And click continue reservation
And verify complete reservation screen pops up
And enter card number
And enter name on the card
And enter expire date and CVC
And checks the agreement
And click complete reservation
Then verify ‘Reservation created successfully’ pop up
And naviaged to Reservations screen
And verify the last reservation is created
When you click on the last reservation
Then verify reservation detail page is displayed
And verify the table has the following fields: Model, Doors, Seats, Luggage, Transmission, Air Conditioning, Fuel Type, Age
And click on back to reservations
And verify Reservations page is displayed
And click on Home link
Then verify the home page is displayed
     */

    HomePage homePage;
    LoginPage loginPage;
    Faker faker;

    @Test
    public void reservationTest(){
//        Given user is on the home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

//     LOGIN THE APP
         loginPage = new LoginPage();
        homePage=new HomePage();
        loginPage= new LoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginButton.click();
//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
        loginPage.emailInput.sendKeys("jack@gmail.com");
//        Type  John.123 into password input
        loginPage.passwordInput.sendKeys("12345");
//        Click on login submit button
        loginPage.loginSubmitButton.click();
//        Verify that user logged in
        //           assertTrue(homePage.usernameDropDown.isDisplayed());
        ReusableMethods.verifyElementDisplayed(homePage.usernameDropDown);//Recommended

//    NOW THAT U LOGGED IN THE APP, WE CAN ENTER REQUIRED FIELDS
//        And select a car
        homePage=new HomePage();
        Select carSelect = new Select(homePage.selectACar);
        carSelect.selectByIndex(3);

//        And enter pick up field
        faker = new Faker();
        homePage.pickUpLocation.sendKeys(Faker.instance(Locale.CANADA).address().cityName());

//        And enter drop off field
        homePage.dropOfLocation.sendKeys(Faker.instance(Locale.CANADA).address().cityName());
        //Pick Up date
        //Pick Up time
        //Drop off date
        //Drop of time

        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("hhmmaa");
        Calendar calendar=Calendar.getInstance();
//        enter pick up date
        homePage.pickUpDate.sendKeys("10/10/2023");
//        enter pick up hour
        homePage.pickUpTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));
//       enter drop of date
        homePage.dropOffDate.sendKeys("12/11/2023");
//        enter drop of hour
        homePage.dropOffTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));



//   ==========================================================================================

//        And click continue reservation
        homePage.continueReservationButton.click();

      //  THERE IS A BLOCKER ,BUG IN APP

//        And verify complete reservation screen pops up

//        And enter card number

//        And enter name on the card

//        And enter expire date and CVC

//        And checks the agreement

//        And click complete reservation

//        Then verify ‘Reservation created successfully’ pop up

//        And naviaged to Reservations screen

//        And verify the last reservation is created

//        When you click on the last reservation

//        Then verify reservation detail page is displayed

//        And verify the table has the following fields: Model, Doors, Seats, Luggage, Transmission, Air Conditioning, Fuel Type, Age

//        And click on back to reservations

//        And verify Reservations page is displayed

//        And click on Home link

//        Then verify the home page is displayed

        Driver.closeDriver();

    }




}
