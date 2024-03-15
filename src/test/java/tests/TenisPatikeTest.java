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
    public void subcategoryTest() {
        //Hover preko Obuca dugmeta, zatim hover preko Sportska obuca, pa klik na patike za tenis, i asertacija
        BasePage basePage = new BasePage(driver);

        basePage.hoverOverCategory(By.xpath("//li[@id='category-node-3289']"));

        basePage.waitVisibilityOf(By.xpath("//li[@id='category-node-33998']"));

        basePage.hoverOverCategory(By.xpath("//li[@id='category-node-33998']"));

        basePage.waitVisibilityOf(By.xpath("//a[@href='https://eplaneta.rs/obuca/sportska-obuca/patike-za-tenis.html']"));

        basePage.clickOnObucaSportskaTenisButton();

//        OVDE NECE DA NADJE "TENIS" DUGME!!!!
//        basePage.clickElement(By.xpath("//a[@href='https://eplaneta.rs/obuca/sportska-obuca/patike-za-tenis.html']"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://eplaneta.rs/obuca/sportska-obuca/patike-za-tenis.html");

        WebElement titleObucaSubcategory = driver.findElement(By.xpath("//h1[@id='page-title-heading']"));

        softAssert.assertEquals(titleObucaSubcategory.getText(), "Patike za tenis");
        softAssert.assertAll("Asertacija je pukla");

        driver.quit();
    }
}
