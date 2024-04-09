package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.HomePage;

import javax.swing.*;
import java.util.List;

public class PretragaFilteriTest extends BaseTest {
    By priceLocatorBy = By.xpath("//span [@class = 'price']");

    @Test
    public void pretragaFilteriTest() {

        BasePage basePage = new BasePage(driver);
        basePage.searchForSomething("nike");
        SoftAssert softAssert = new SoftAssert();

        Assert.assertEquals(driver.getCurrentUrl(), "https://eplaneta.rs/catalogsearch/result/?q=nike");

        basePage.priceRange("2000", "5000");

        basePage.waitForLoader();

        Assert.assertEquals(driver.getCurrentUrl(), "https://eplaneta.rs/catalogsearch/result/index/?price=2000.00-5000.00&q=nike");

        basePage.waitVisibility(By.xpath("//li [@data-label= 'Sport i hobi']"));
        basePage.kategorijaFilter(By.xpath("//li [@data-label= 'Sport i hobi']"));

        basePage.waitForLoader();

        softAssert.assertEquals(driver.getCurrentUrl(), "https://eplaneta.rs/catalogsearch/result/index/?cat=4081&price=2000.00-5000.00&q=nike");

        WebElement itemsContainer = driver.findElement(By.xpath("//ol[@class = 'products list items product-items']"));

        List<WebElement> itemsList = itemsContainer.findElements(By.xpath(".//span [@class = 'special-price']"));
        itemsList.forEach(e -> {
            String priceAsString = e.getText().replace(".", "").substring(0, 4);

            System.out.println(priceAsString + " SPECIAL");
            double priceAsDouble = Double.parseDouble(priceAsString);
            softAssert.assertTrue(priceAsDouble < 5000 && priceAsDouble > 2000);

        });

        List<WebElement> itemsList2 = itemsContainer.findElements(By.xpath(".//span [@class = 'normal-price special-price ']"));
        itemsList2.forEach(e -> {
            String priceAsString = e.getText().replace(".", "").substring(0, 4);

            System.out.println(priceAsString + " NORMAL SPECIAL");

            double priceAsDouble = Double.parseDouble(priceAsString);
            softAssert.assertTrue(priceAsDouble < 5000 && priceAsDouble > 2000);

        });

        List<WebElement> itemsList3 = itemsContainer.findElements(By.xpath(".//span [@class = 'normal-price regular ']"));
        itemsList3.forEach(e -> {
            String priceAsString = e.getText().replace(".", "").substring(0, 4);

            System.out.println(priceAsString + " REGULAR");

            double priceAsDouble = Double.parseDouble(priceAsString);
            softAssert.assertTrue(priceAsDouble < 5000 && priceAsDouble > 2000);

        });
        softAssert.assertAll();
    }
}
