package tests;

import common.BrowserManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BrowserManager {
    @BeforeMethod
    public void setup() {

        startChrome();
        driver.get("https://eplaneta.rs/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}