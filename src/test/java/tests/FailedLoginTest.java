package tests;

import dataGenerator.DataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class FailedLoginTest extends BaseTest {
    @Test
    public void failedLogin() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickOnProfileButton();

        WebElement loginContainer = driver.findElement(By.xpath("//div [@class = 'block block-social-login']"));
        if (driver.findElement(By.id("block-customer-heading")).getText().contains("Kreiraj nalog")) {
            driver.findElement(By.xpath("//p [@id = 'login-register-btn']")).click();
        } else {
            driver.findElement(loginPage.getEmailFieldBy()).sendKeys(DataGenerator.generateEmail());
            driver.findElement(loginPage.getPasswordFieldBy()).sendKeys(DataGenerator.generatePassword());
            driver.findElement(loginPage.getLoginButtonBy()).click();
        }

        Thread.sleep(3000);

        softAssert.assertEquals(driver.getCurrentUrl(), "https://eplaneta.rs/customer/account/login", "Asertacija pukla kod kredencijala");
        softAssert.assertEquals(driver.findElement(By.xpath("//div [text()= 'Neuspešna prijava ili je tvoj nalog ugašen. Pokušaj ponovo.']"))
                .getText(), "Neuspešna prijava ili je tvoj nalog ugašen. Pokušaj ponovo.");
        softAssert.assertAll();
    }
}
