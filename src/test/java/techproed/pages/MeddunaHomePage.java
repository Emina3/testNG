package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class MeddunaHomePage {

    public MeddunaHomePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="account-menu")
    public WebElement userIcon;

    @FindBy(id="login-item")
    public WebElement signInOption;

    @FindBy(id="entity-menu")
    public WebElement itemsAndTitlesMenu;

    @FindBy(linkText="Patient")
    public WebElement patientOption;

}
