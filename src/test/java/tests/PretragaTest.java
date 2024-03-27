package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;

import java.util.List;

public class PretragaTest extends BaseTest {

    @Test
    public void pretragaTest() {

        BasePage basePage = new BasePage(driver);
        basePage.searchForSomething("adidas");

        Assert.assertEquals(driver.getCurrentUrl(), "https://eplaneta.rs/catalogsearch/result/?q=adidas");

        List<WebElement> listOfItems = driver.findElements(By.xpath("//a[@class='product-item-link']"));

        SoftAssert softAssert = new SoftAssert();

        listOfItems.forEach(element -> {
            softAssert.assertTrue(element.getText().contains("ADIDAS"), "NIJE DOBRO: " + element.getText());
        });
        softAssert.assertAll();
    }
}
