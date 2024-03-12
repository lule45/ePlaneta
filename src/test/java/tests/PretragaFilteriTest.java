package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

import java.util.List;

public class PretragaFilteriTest extends BaseTest {

    @Test
    public void pretragaFilteriTest() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.searchForSomething("nike");

        Assert.assertEquals(driver.getCurrentUrl(), "https://eplaneta.rs/catalogsearch/result/?q=nike");

        basePage.priceRange("2000", "5000");

        basePage.waitVisibilityOf(By.xpath("//div [@class = 'loader']"));
        basePage.waitInvisibility(By.xpath("//div [@class = 'loader']"));

        Assert.assertEquals(driver.getCurrentUrl(),"https://eplaneta.rs/catalogsearch/result/index/?price=2000.00-5000.00&q=nike");

        //filter by Sport i hobi
        basePage.waitVisibility(By.xpath("//li [@data-label= 'Sport i hobi']"));
        basePage.kategorijaFilter(By.xpath("//li [@data-label= 'Sport i hobi']"));

        basePage.waitVisibilityOf(By.xpath("//div [@class = 'loader']"));
        basePage.waitInvisibility(By.xpath("//div [@class = 'loader']"));

        Assert.assertEquals(driver.getCurrentUrl(),"https://eplaneta.rs/catalogsearch/result/index/?cat=4081&price=2000.00-5000.00&q=nike");

        List<WebElement> listaNike2kDo5k = driver.findElements(By.xpath("//span[@class='normal-price special-price']"));
        listaNike2kDo5k.forEach(e -> {
            String priceAsString = e.getText().replace(",99 RSD", "");

            if(!priceAsString.isBlank()){
                double priceAsDouble =  Double.parseDouble(priceAsString.replace(".",""));

                Assert.assertTrue(priceAsDouble<5000 && priceAsDouble>2000);
            }
        });

    }
}
