package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Reporter;
import pages.SauceDemoLoginPage;
import tests.BaseTest;

public class MainSteps extends BaseTest {

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");

    @Before
    public void setup() throws Exception {
        init(browser);
    }

    @After
    public void tearDown(){
        if(quit.equalsIgnoreCase("Yes")) {
            quit();
        }
    }

    @Given("I am on the sauce demo login page")
    public void iAmOnTheSauceDemoLoginPage(){
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter my username {string}")
    public void iEnterMyUsername(String username) {
        new SauceDemoLoginPage(driver).enterUsername(username);
    }

    @And("I enter my password {string}")
    public void iEnterMyPassword(String password) {
        new SauceDemoLoginPage(driver).enterPassword(password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        new SauceDemoLoginPage(driver).clickLogin();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        new SauceDemoLoginPage(driver).menuShouldBeVisible();
    }

    @And("I should be able to see products")
    public void iShouldBeAbleToSeeProducts() {
        new SauceDemoLoginPage(driver).titleShouldBeVisible();
    }

    @Then("I should see error message {string}")
    public void iShouldSeeErrorMessage(String errorMessage) {
        new SauceDemoLoginPage(driver).verifyErrorMessage(errorMessage);
    }
}