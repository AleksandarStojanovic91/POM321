package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By brands  = By.cssSelector("[title=' Sve marke']");

    public void selectBrand(String brand){
        driver.findElement(brands).sendKeys(brand);
    }

}
