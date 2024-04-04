package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CartPage;
import pages.HomePage;

public class AddRandomItem extends BaseTest {
    @Test
    public void addRandomItemToCart() throws InterruptedException {
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
        Assert.assertEquals(productSku, productInCartSku);

        Thread.sleep(3000);

        Assert.assertEquals(productSku, productInCartSku, "SIFRA SE NE PODUDARA");
    }

    @Test
    public void removeItemFromCart() {
        BasePage basePage = new BasePage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        basePage.searchForSomething("beko");

        basePage.waitVisibility(homePage.getinventoryItemsBy());

        homePage.addRandomItemToCart();
        basePage.waitVisibility(By.xpath("//div [@class = 'subtotal']"));

        cartPage.removeItemFromCart();

        WebElement nestoTamo = driver.findElement(By.xpath("//div [@class = 'block-content']"));

        WebElement emptyCartText = nestoTamo.findElement(By.xpath("//div [@id = 'minicart-content-wrapper']"));

        basePage.waitInvisibility(By.xpath("//a [@class = 'action delete']"));

        Assert.assertEquals(emptyCartText.getText(), "Nemaš artikle u korpi.", "KORPA NIJE POTPUNO PRAZNA?");

    }
}
