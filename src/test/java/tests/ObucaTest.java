package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.HomePage;
import pages.ObucaPage;

public class ObucaTest extends BaseTest {
    @Test
    public void categoryTest() {

        BasePage basePage = new BasePage(driver);

        basePage.goToCategoryPage(By.xpath("//li[@id='category-node-3289']"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://eplaneta.rs/obuca.html");
        softAssert.assertEquals(driver.findElement(By.id("page-title-heading")).getText(), "Obuća");
        softAssert.assertAll();
    }
}
