package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ObucaPage;

public class ObucaTest extends BaseTest {


    @Test
    public void obucaTest() {

        HomePage homePage = new HomePage(driver);
        ObucaPage obucaPage = new ObucaPage(driver);

        homePage.goToObucaPage();
        Assert.assertEquals(driver.getCurrentUrl(), obucaPage.obucaURL());

        obucaPage.titleObuca();
        Assert.assertEquals(obucaPage.titleObuca().getText(), "Obuća");

    }
}
