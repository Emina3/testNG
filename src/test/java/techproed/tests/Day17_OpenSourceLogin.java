package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day17_OpenSourceLogin {
    /*
      POM:
      1.Locate the page objects in the pages package
      -username input
      -password input
      -login button
      NOTE: Use constructor to instantiate page object

     */

    @Test
    public void loginTest() throws InterruptedException {
        OpenSourcePage openSourcePage=new OpenSourcePage();
        Driver.getDriver().get(ConfigReader.getProperty("open_source_URL"));
        Thread.sleep(1000);
        openSourcePage.userName.sendKeys(ConfigReader.getProperty("open_source_admin_username"));
        Thread.sleep(1000);
        openSourcePage.password.sendKeys(ConfigReader.getProperty("open_source_admin_password"));
        Thread.sleep(1000);
        openSourcePage.logInSubmit.click();

        Driver.closeDriver();

    }

    /*
    git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Emina3/testNG.git
git push -u origin main
     */


}
