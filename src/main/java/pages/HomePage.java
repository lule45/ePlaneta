package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public static void main(String[] args) {
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToObucaPage() {
        obucaElement().click();
    }
}