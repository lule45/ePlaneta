package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObucaPage extends BasePage {
    By titleObucaBy = By.id("page-title-heading");
    String obucaURL = "https://eplaneta.rs/obuca.html";

    public ObucaPage(WebDriver driver) {
        super(driver);
    }

    public WebElement titleObuca() {
        WebElement titleObuca = driver.findElement(titleObucaBy);
        return titleObuca;
    }

    public String obucaURL() {

        return obucaURL;
    }
}
