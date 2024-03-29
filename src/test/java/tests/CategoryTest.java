package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;

public class CategoryTest extends BaseTest {
    @Test

    public void categoryTest() {
        BasePage basePage = new BasePage(driver);

        basePage.goToCategoryPage(By.xpath("//li[@id='category-node-328']"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://eplaneta.rs/obuca.html");
        softAssert.assertEquals(driver.findElement(By.id("page-title-heading")).getText(), "Obuća");
        softAssert.assertAll();
    }
}
