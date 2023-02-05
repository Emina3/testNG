package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import techproed.pages.HomePage;
import techproed.pages.VendorPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day16_Annotations {

    /*
    suit > test > group > class > method
    @Test : Creates test case
    @Before and @After : 10 before and after annotations.They are used to control the FLOW and DESIGN of the test cases
    @Ignore : skip test case
    @Test(enable=false) :Disable the test case.By default, enable=true.
    @Test(priority=number) : prioritize/order test case execution.
    NOTE: Tests that has no priority parameter has a priority of 0.Test(priority=0)
    TestNG test cases runs in alphabetical order by default.//
    We should use priority when there are multiple test cases in the same class.
    -3,0(ALSO TEST WITH NO PRIORITY),4,9
     */
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");

    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");

    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");

    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @Test(priority = 2)
    public void test1() {
        System.out.println("test1");
    }


    @Ignore
    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test(enabled = false)
    public void test3() {
        System.out.println("test3");
    }

    @Test(priority = 3)
    public void test4() {
        System.out.println("test4");
    }

    @Test(groups = "minor-regression-group", priority = 1)
    public void test5() {
        System.out.println("test5");

    }

    @Test(groups = "minor-regression-group")
    public void test6() {
        System.out.println("test6");
    }

}



//    /*
//    Given
//         User goes to "https://allovercommerce.com
//     When
//         User clicks on Sign In link
//      And
//         User enters email address into "email" input
//      And
//         User enters password into "email" input
//      And
//         User clicks on "Sign In" Button
//      And
//         User click on "Sing Out" link
//      Then
//          Verify that "My Account" is visible
//     */
//    @Test
//    public void vendorSignInAndMyAccountVisibility() {
//
//        //    User goes to "https://allovercommerce.com
//        ReusableMethods.waitFor(3);
//        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
//
//        //    User clicks on Sign In link
//        HomePage homePage = new HomePage();
//        homePage.signInSection.click();
//
//        //   User enters email address into "email" input
//        homePage.username.sendKeys(ConfigReader.getProperty("vendor_email"));
//        ReusableMethods.waitFor(1);
//
//        //   User enters password into "email" input
//        homePage.password.sendKeys(ConfigReader.getProperty("vendor_password"));
//        ReusableMethods.waitFor(1);
//
//
//        //   User clicks on "Sign In" Button
//        homePage.signInButton.click();
//        ReusableMethods.waitFor(5);
//
//        // User click on "Sing Out" link
//        homePage.signOut.click();
//        ReusableMethods.waitFor(5);
//
//        //   Verify that "My Account" is visible
//        VendorPage vendorPage = new VendorPage();
//        ReusableMethods.waitFor(10);
//        Assert.assertTrue(vendorPage.myAccountHeader.isDisplayed());
//
//    }
//
//    @AfterMethod
//    public void closeDriver1(){
//        ReusableMethods.waitFor(2);
//        Driver.closeDriver();
//    }
//
//
//      /*
//    Given
//         User goes to "https://allovercommerce.com
//     When
//         User clicks on Sign In link
//      And
//         User enters email address into "email" input
//      And
//         User enters password into "email" input
//      And
//         User clicks on "Sign In" Button
//      And
//         User click on "Sing Out" link
//      Then
//          Verify that Orders, Downloads, Addresses, Account Details, Whishlist and Logout are visible
//     */
//
//    @Test
//    public void visibilityOfWebElements() {
//
//        //    User goes to "https://allovercommerce.com
//        ReusableMethods.waitFor(3);
//        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
//
//        //    User clicks on Sign In link
//        HomePage homePage = new HomePage();
//        homePage.signInSection.click();
//
//        //   User enters email address into "email" input
//        homePage.username.sendKeys(ConfigReader.getProperty("vendor_email"));
//        ReusableMethods.waitFor(1);
//
//        //   User enters password into "email" input
//        homePage.password.sendKeys(ConfigReader.getProperty("vendor_password"));
//        ReusableMethods.waitFor(1);
//
//
//        //   User clicks on "Sign In" Button
//        homePage.signInButton.click();
//        ReusableMethods.waitFor(5);
//
//
//        // User click on "Sing Out" link
//        homePage.signOut.click();
//        ReusableMethods.waitFor(5);
//
//        //   Verify that Orders, Downloads, Addresses, Account Details, Whishlist and Logout are visible
//        VendorPage vendorPage = new VendorPage();
//        ReusableMethods.waitFor(10);
//
//        ReusableMethods.verifyElementDisplayed(vendorPage.ordersLink);
//        ReusableMethods.waitFor(2);
//        ReusableMethods.verifyElementDisplayed(vendorPage.downloadsLink);
//        ReusableMethods.waitFor(2);
//        ReusableMethods.verifyElementDisplayed(vendorPage.addressesLink);
//        ReusableMethods.waitFor(2);
//        ReusableMethods.verifyElementDisplayed(vendorPage.accountDetailsLink);
//        ReusableMethods.waitFor(2);
//        ReusableMethods.verifyElementDisplayed(vendorPage.whishlistLink);
//        ReusableMethods.waitFor(2);
//        ReusableMethods.verifyElementDisplayed(vendorPage.logoutLink);
//        ReusableMethods.waitFor(2);
//
//    }
//    @AfterMethod
//    public void closeDriver(){
//        ReusableMethods.waitFor(2);
//        Driver.closeDriver();
//    }
//
//
//        /*
//    Given
//         User goes to "https://allovercommerce.com
//     When
//         User clicks on Sign In link
//      And
//         User enters email address into "email" input
//      And
//         User enters password into "email" input
//      And
//         User clicks on "Sign In" Button
//      And
//         User click on "Sing Out" link
//      Then
//          Verify that Store Manager, Orders, Downloads,Addresses, Account Details, Whishlist,
//          Support Tickets,Followings and Logout should be visible on Dashboard
//
//     */
//
//
//    @Test
//    public void visibilityOfWebElementsOnDashboard() {
//
//        //    User goes to "https://allovercommerce.com
//        ReusableMethods.waitFor(3);
//        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
//
//        //    User clicks on Sign In link
//        HomePage homePage = new HomePage();
//        homePage.signInSection.click();
//
//        //   User enters email address into "email" input
//        homePage.username.sendKeys(ConfigReader.getProperty("vendor_email"));
//        ReusableMethods.waitFor(1);
//
//        //   User enters password into "email" input
//        homePage.password.sendKeys(ConfigReader.getProperty("vendor_password"));
//        ReusableMethods.waitFor(1);
//
//
//        //   User clicks on "Sign In" Button
//        homePage.signInButton.click();
//        ReusableMethods.waitFor(5);
//
//
//        // User click on "Sing Out" link
//        homePage.signOut.click();
//        ReusableMethods.waitFor(5);
//
//        //   Verify that Store Manager, Orders, Downloads,Addresses, Account Details, Whishlist,
//        //   Support Tickets,Followings and Logout should be visible on Dashboard
//
//
//        VendorPage vendorPage = new VendorPage();
//        ReusableMethods.waitFor(10);
//
//        ReusableMethods.verifyElementDisplayed(vendorPage.storeManagerLink);
//        ReusableMethods.waitFor(2);
//        ReusableMethods.verifyElementDisplayed(vendorPage.ordersLink);
//        ReusableMethods.waitFor(2);
//        ReusableMethods.verifyElementDisplayed(vendorPage.downloadsLink);
//        ReusableMethods.waitFor(2);
//        ReusableMethods.verifyElementDisplayed(vendorPage.addressesLink);
//        ReusableMethods.waitFor(2);
//        ReusableMethods.verifyElementDisplayed(vendorPage.accountDetailsLink);
//        ReusableMethods.waitFor(2);
//        ReusableMethods.verifyElementDisplayed(vendorPage.whishlistDashboardLink);
//        ReusableMethods.waitFor(2);
//        ReusableMethods.verifyElementDisplayed(vendorPage.supportTicketsLink);
//        ReusableMethods.waitFor(2);
//        ReusableMethods.verifyElementDisplayed(vendorPage.followingsLink);
//        ReusableMethods.waitFor(2);
//        ReusableMethods.verifyElementDisplayed(vendorPage.logoutLink);
//        ReusableMethods.waitFor(2);
//
//    }
//        @AfterMethod
//        public void closeDriver2(){
//            ReusableMethods.waitFor(2);
//            Driver.closeDriver();
//        }
//
//    }
//
