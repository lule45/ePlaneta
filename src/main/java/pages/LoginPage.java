package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    By loginButtonBy = By.xpath("//span[@class = 'customer-name']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginButton (){
        clickElement(loginButtonBy);
    }
}
