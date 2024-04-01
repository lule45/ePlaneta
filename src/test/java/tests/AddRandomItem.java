package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

public class AddRandomItem extends BaseTest{
    @Test
    public void addRandomItemToCart ()throws InterruptedException{
        BasePage basePage = new BasePage(driver);
        HomePage homePage = new HomePage(driver);

        basePage.searchForSomething("beko");
        basePage.waitVisibility(homePage.getinventoryItemsBy());
        homePage.addRandomItemToCart();
        basePage.waitVisibility(By.xpath("//div [@class = 'subtotal']"));
        String productSku = homePage.readTextFromElement(By.xpath("//div [@itemprop = '']"));
        String productInCartSku = homePage.readTextFromElement(
                By.xpath("//span [@data-bind = 'text: product_sku']"));

        System.out.println(productInCartSku);
        System.out.println(productSku);
        Assert.assertEquals(productSku,productInCartSku);

        Thread.sleep(3000);

//        Assert.assertEquals();
    }
}
