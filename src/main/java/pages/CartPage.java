package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    By ukloniButtonBy = By.xpath("//a [@class = 'action delete']");

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public void removeItemFromCart() {
        WebElement ukloniButton = driver.findElement(ukloniButtonBy);
        waitVisibilityOf(ukloniButtonBy);
        ukloniButton.click();
        waitVisibilityOf(getRemoveButtonConfirmationBy());
        WebElement deleteItemButtonConfirmation = driver.findElement(getRemoveButtonConfirmationBy());
        deleteItemButtonConfirmation.click();
    }
}
