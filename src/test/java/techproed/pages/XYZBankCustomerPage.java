package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class XYZBankCustomerPage {

    public XYZBankCustomerPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "userSelect")
    public WebElement yourNameDropDown;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    public WebElement depositButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    public WebElement amountToBeDeposit;

    @FindBy(xpath = "//button[.='Deposit']")
    public WebElement depositSubmitButton;

    @FindBy(xpath = "//span[@ng-show='message']")
    public WebElement depositSuccessMessageButton;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    public WebElement withdrawlButton;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement amoutToBeWithdrawnInput;

    @FindBy(xpath = "//button[.='Withdraw']")
    public WebElement withdrawSubmitButton;

    @FindBy(xpath = "//span[.='Transaction successful']")
    public WebElement transactionSuccessMessage;

    @FindBy(xpath = "//button[.='Logout']")
    public WebElement logOutButton;
}
