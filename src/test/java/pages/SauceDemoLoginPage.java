package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SauceDemoLoginPage extends BasePage{

    public SauceDemoLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#user-name")
    WebElement usernameInput;

    @FindBy(css = "#password")
    WebElement passwordInput;

    @FindBy(css = "#login-button")
    WebElement loginButton;

    @FindBy(css = "h3")
    WebElement errorMessage;

    // Inventory page
    @FindBy(css = "#react-burger-menu-btn")
    WebElement menu;

    @FindBy(css = ".title")
    WebElement title;
    // Inventory page

    public void enterUsername(String username){
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickLogin(){
        click(loginButton);
    }

    public void verifyErrorMessage(String errorMessageText){
        Assert.assertEquals(errorMessage.getText(),errorMessageText);
    }

    // Inventory page
    public void menuShouldBeVisible(){
        Assert.assertTrue(menu.isDisplayed());
    }

    public void titleShouldBeVisible(){
        Assert.assertTrue(title.isDisplayed());
    }
    // Inventory page

}
