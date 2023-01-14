package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePF extends BasePage{

    public HomePagePF(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "p[title=' Sve marke']")
    WebElement brands;
    @FindBy(css = "[title=' Svi modeli']")
    WebElement models;
    @FindBy(css = "[name='submit_1']")
    WebElement searchButton;

    public void selectBrand(String brand) throws Exception {
        click(brands, brand);
        click(driver.findElement(By.xpath("//label[text()='"+brand+"']")), brand);
    }

    public void selectModel(String model) throws Exception {
        click(models,model);
        click(driver.findElement(By.xpath("//label[contains(text(),'"+model+"')]")),model);
    }

    public void clickSearch() throws Exception {
        click(searchButton, "Search Button");
    }

    public void searchVehicle(String brand, String model) throws Exception {
        selectBrand(brand);
        selectModel(model);
        clickSearch();
    }
}
