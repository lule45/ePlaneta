package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public void removeItemFromCart() {
        WebElement ukloniButton = driver.findElement(By.xpath("//a [@class = 'action delete']"));
        waitVisibilityOf(By.xpath("//a [@class = 'action delete']"));
        ukloniButton.click();
        waitVisibilityOf(getRemoveButtonConfirmationBy());
        WebElement deleteItemButtonConfirmation = driver.findElement(getRemoveButtonConfirmationBy());
        deleteItemButtonConfirmation.click();
    }
}
