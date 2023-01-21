package tests;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import selenium.DriverManager;
import selenium.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    DriverManager driverManager;
    public WebDriver driver;
    String path = "src/results/screenshots/";

    public void init(String type) throws Exception {
        driverManager = DriverManagerFactory.getDriverManager(type);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void quit() {
        driverManager.quitDriver();
    }

    public void openApp(String env) throws Exception {
        env = env.toUpperCase();
        switch (env) {
            case "LOCAL": {
                driver.get("https://www.local.polovniautomobili.com"); //198.162.1.1:4323
            }
            break;
            case "DEV": {
                driver.get("https://www.dev.polovniautomobili.com");
            }
            break;
            case "QA": {
                driver.get("https://www.qa.polovniautomobili.com");
            }
            break;
            case "STG": {
                driver.get("https://www.stg.polovniautomobili.com");
            }
            break;
            case "UAT": {
                driver.get("https://www.uat.polovniautomobili.com");
            }
            break;
            case "PROD": {
                driver.get("https://www.polovniautomobili.com");
            }
            break;
            default:
                throw new Exception("Environment: " + env + " not supported!");
        }
    }

    public void takeScreenshot(String fileName) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(path + fileName + ".png"));
    }

    public void reporterScreenshot(String fileName, String desc) throws IOException {
        takeScreenshot(fileName);
        Path filePath = Paths.get(path + fileName + ".png");
        InputStream is = Files.newInputStream(filePath);
        Allure.addAttachment(desc, is);
    }

}
