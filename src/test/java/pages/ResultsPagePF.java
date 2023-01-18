package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ResultsPagePF extends BasePage{

    public ResultsPagePF(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "h1")
    WebElement title;

    public void verifyTitle(String titleText) throws Exception {
        Assert.assertEquals(title.getText(),titleText);
    }
}
