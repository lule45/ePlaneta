package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

import java.util.List;

public class PretragaFilteriTest extends BaseTest {

    @Test
    public void pretragaFilteriTest() {

        BasePage basePage = new BasePage(driver);
        basePage.searchForSomething("nike");

        Assert.assertEquals(driver.getCurrentUrl(), "https://eplaneta.rs/catalogsearch/result/?q=nike");

        basePage.priceRange("2000", "5000");

        basePage.waitForLoader();

        Assert.assertEquals(driver.getCurrentUrl(), "https://eplaneta.rs/catalogsearch/result/index/?price=2000.00-5000.00&q=nike");

        basePage.waitVisibility(By.xpath("//li [@data-label= 'Sport i hobi']"));
        basePage.kategorijaFilter(By.xpath("//li [@data-label= 'Sport i hobi']"));

        basePage.waitForLoader();

        Assert.assertEquals(driver.getCurrentUrl(), "https://eplaneta.rs/catalogsearch/result/index/?cat=4081&price=2000.00-5000.00&q=nike");

        List<WebElement> priceFiltersList = driver.findElements(By.xpath("//span[@class='normal-price special-price']"));
        priceFiltersList.forEach(e -> {
            String priceAsString = e.getText().replace(",99 RSD", "");

            if (!priceAsString.isBlank()) {
                double priceAsDouble = Double.parseDouble(priceAsString.replace(".", ""));

                Assert.assertTrue(priceAsDouble < 5000 && priceAsDouble > 2000);
            }
        });
    }
}
