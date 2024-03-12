package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;

public class TenisPatikeTest extends BaseTest {
    By obucaSportskaBy = By.xpath("//li[@id='category-node-33998']");
    By obucaSportskaTenisBy = By.xpath("//a[@href='https://eplaneta.rs/obuca/sportska-obuca/patike-za-tenis.html']");


    @Test
    public void tenisPatiketTest() {
        //Hover preko Obuca dugmeta, zatim hover preko Sportska obuca, pa klik na patike za tenis, i asertacija
        BasePage basePage = new BasePage(driver);

        basePage.hoverOverLinkToObuca();

        basePage.waitVisibilityOf(basePage.getLinkObucaSportskaBy());

        basePage.hoverOverlinkToObucaSportska();

        basePage.waitVisibilityOf(basePage.getLinkObucaSportskaTenisBy());

        basePage.clickOnObucaSportskaTenisButton();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getCurrentUrl(), "https://eplaneta.rs/obuca/sportska-obuca/patike-za-tenis.html");

        WebElement titleObucaTenis = driver.findElement(By.xpath("//h1[@id='page-title-heading']"));

        softAssert.assertEquals(titleObucaTenis.getText(), "Patike za tenis");
        softAssert.assertAll("Asertacija je pukla");

        driver.quit();
    }
}
