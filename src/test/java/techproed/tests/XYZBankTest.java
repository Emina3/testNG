package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.XYZBankManagerPage;
import techproed.pages.XYZBankCustomerPage;
import techproed.pages.XZYBankHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertTrue;

public class XYZBankTest {

    //Open 5 new Accounts, deposit 100 USD and withdraw 100 USD from any account and delete all accounts you created

      /*
            Given
                Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
            When
                Click on "Bank Manager Login" button
            And
                Click on "Add Customer" button
            And
                Fill inputs and click on "Add Customer" submit button
            And
                Accept alert
            And
                Add 4 more customers
            And
                Click on "Open Account"  button
            And
                Click on "Customer" dropdown
            And
                Select customer name
            And
                Click on "Currency" dropdown
            And
                Select "Dollar"
            And
                Click on "Process" button
            And
                Accept alert
            And
                Open 4 more accounts
            And
                Click on "Customers" button
            And
                Count table row numbers
            Then
                Assert that you created 5 customers
            When
                Click on "Home" button
            And
                Click on "Customer Login" button
            And
                Click on "Your Name" dropdown
            And
                Select  any name you created
            And
                Click on "Login" button
            And
                Click on "Deposit" button
            And
                Type 100 into "Amount to be Deposited" input
            And
                Click on "Deposit"(Submit) button
            Then
                Assert that "Deposit Successful" is displayed

            And
                Click on "Withdrawal" button
            And
                Type 100 into "Amount to be Withdrawn" input
            And
                Click on "Withdraw"(Submit) button
            Then
                Assert that "Transaction  Successful" is displayed
            When
                Click on "Logout" button
            And
                Click on "Home" button
            And
                Click on "Bank Manager Login" button
            And
                Click on "Customers" button
            And
                Click on each "Delete" button
            And
                Count table row numbers
            Then
                Assert that number of customers is 0

 */

    @Test(groups = "smoke-test")
    public void xzyBank(){
//        Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        Driver.getDriver().get(ConfigReader.getProperty("xzy_bank_url"));

//        Click on "Bank Manager Login" button
        XZYBankHomePage xzyBankHomePage = new XZYBankHomePage();
        xzyBankHomePage.bankManagerLoginButton.click();

//        Click on "Add Customer" button
        XYZBankManagerPage xyzBankManagerPage = new XYZBankManagerPage();
        xyzBankManagerPage.bankManagerLogin.click();

//        Fill inputs and click on "Add Customer" submit button
        //        Add 4 more customers
        Faker faker = new Faker();
        for(int i=0; i<5; i++) {


            //  xyzBankManagerPage.firstnameInput.sendKeys(Faker.instance().name().firstName());
            xyzBankManagerPage.firstnameInput.sendKeys(faker.name().firstName());
            xyzBankManagerPage.lastnameInput.sendKeys(faker.name().lastName());
            xyzBankManagerPage.postCodeInput.sendKeys(faker.address().zipCode());
            xyzBankManagerPage.addCustomerSubmitButton.click();

//        Accept alert
            try {
                Driver.getDriver().switchTo().alert().accept();
            } catch (Exception ignored) {

            }
        }



//        Click on "Open Account"  button
        xyzBankManagerPage.openAccountButton.click();

//        Click on "Customer" dropdown
//        Select customer name


            Select select = new Select(xyzBankManagerPage.customerDropDown);
            Select select2 = new Select(xyzBankManagerPage.currencyDropDown);

            for(int i = 6; i<11; i++) {
                select.selectByIndex(i);

//        Click on "Currency" dropdown
//        Select "Dollar"
                select2.selectByIndex(1);

//        Click on "Process" button
                xyzBankManagerPage.processSubmitButton.click();
//        Accept alert

                try {
                    Driver.getDriver().switchTo().alert().accept();

                } catch (Exception ignored) {

                }
                //        Open 4 more accounts
            }

//        Click on "Customers" button
          xyzBankManagerPage.customersButton.click();
//        Count table row numbers
          int numberOfRows = xyzBankManagerPage.numberOfRows.size();

//        Assert that you created 5 customers
        Assert.assertEquals(10,numberOfRows);

//        Click on "Home" button
           xyzBankManagerPage.homeButton.click();

//        Click on "Customer Login" button
         xzyBankHomePage.customerLoginButton.click();

//        Click on "Your Name" dropdown
//        Select  any name you created
        XYZBankCustomerPage xyzBankCustomerPage = new XYZBankCustomerPage();
        Select select3 = new Select(xyzBankCustomerPage.yourNameDropDown);
        select3.selectByIndex(6);

//        Click on "Login" button
        xyzBankCustomerPage.loginButton.click();

//        Click on "Deposit" button
        xyzBankCustomerPage.depositButton.click();

//        Type 100 into "Amount to be Deposited" input
        xyzBankCustomerPage.amountToBeDeposit.sendKeys("100");

//        Click on "Deposit"(Submit) button
        xyzBankCustomerPage.depositSubmitButton.click();

        //        Assert that "Deposit Successful" is displayed
        Assert.assertEquals("Deposit Successful",xyzBankCustomerPage.depositSuccessMessageButton.getText());

//        Click on "Withdrawal" button
        xyzBankCustomerPage.withdrawlButton.click();

//        Type 100 into "Amount to be Withdrawn" input
        ReusableMethods.waitFor(2);
        xyzBankCustomerPage.amoutToBeWithdrawnInput.click();
        xyzBankCustomerPage.amoutToBeWithdrawnInput.sendKeys("100", Keys.ENTER);
        ReusableMethods.waitFor(2);

//        Click on "Withdraw"(Submit) button
 //       xzyBankCustomerPage.withdrawSubmitButton.click(); ===>Selenium click is not working
        Actions actions = new Actions(Driver.getDriver());
        actions.click(xyzBankCustomerPage.withdrawSubmitButton).perform();

//        Assert that "Transaction  Successful" is displayed
          assertTrue(xyzBankCustomerPage.transactionSuccessMessage.isDisplayed());
        ReusableMethods.verifyElementDisplayed(xyzBankCustomerPage.transactionSuccessMessage);

//        Click on "Logout" button
         xyzBankCustomerPage.logOutButton.click();

//        Click on "Home" button
        xyzBankManagerPage.homeButton.click();

//        Click on "Bank Manager Login" button
        xzyBankHomePage.bankManagerLoginButton.click();
//        Click on "Customers" button

//        Click on each "Delete" button
        for(WebElement  w : xyzBankManagerPage.deleteButtons){
            ReusableMethods.waitFor(1);
            w.click();

        }

//        Count table row numbers
       int numbOfRowsAfterDelete = xyzBankManagerPage.deleteButtons.size();

//        Assert that number of customers is 0
        Assert.assertEquals(0,numbOfRowsAfterDelete);

    }

    @AfterMethod
    public void closeDriver(){
        ReusableMethods.waitFor(2);
        Driver.closeDriver();
    }
}
