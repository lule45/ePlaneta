package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By profileButtonBy = By.xpath("//span[@class = 'customer-name']");
    private By emailFieldBy = By.id("email");
    private By passwordFieldBy = By.id("sidebar-pass");
    private By loginButtonBy = By.id("send2");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public By getProfileButtonBy() {
        return profileButtonBy;
    }

    public By getEmailFieldBy() {
        return emailFieldBy;
    }

    public By getPasswordFieldBy() {
        return passwordFieldBy;
    }

    public By getLoginButtonBy() {
        return loginButtonBy;
    }

    public void clickOnLoginButton (){
        clickElement(loginButtonBy);
    }

    public void clickOnProfileButton (){
        clickElement(profileButtonBy);
    }

}
