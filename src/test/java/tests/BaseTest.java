package tests;

import common.BrowserManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest extends BrowserManager {
    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("Chrome") String browser) {
        switch (browser.toLowerCase()){
            case "chrome":
                startChrome();
                break;
            case "edge":
                startEdge();
                break;
            case "firefox":
                startFirefox();
                break;
            default:
                startChrome();
        }
        driver.get("https://eplaneta.rs/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}