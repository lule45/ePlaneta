package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private By inventoryItemsBy = By.xpath("//li [@class = 'item product product-item']");
    By inventoryNameBy = By.xpath("//strong [@class = 'product name product-item-name']");
    By productNameBy = By.xpath("//span [@class= 'product-name']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static void main(String[] args) {
    }

    public By getinventoryItemsBy() {
        return inventoryItemsBy;
    }

    public void addRandomItemToCart() {
        WebElement inventoryItem = selectRandomWebElement(inventoryItemsBy);
        inventoryItem.click();
        WebElement addToCartButton = driver.findElement(getAddToCartButtonBy());
        addToCartButton.click();
    }

    public String readTextFromElement(By elementLocator) {
        waitVisibility(elementLocator);
        return driver.findElement(elementLocator).getText();
    }
}