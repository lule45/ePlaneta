package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

import java.util.List;

public class PretragaTest extends BaseTest {

    @Test
    public void pretragaTest() {
        BasePage basePage = new BasePage(driver);
        basePage.searchForSomething("adidas");


        Assert.assertEquals(driver.getCurrentUrl(), "https://eplaneta.rs/catalogsearch/result/?q=adidas");

        List<WebElement> listaPatika = driver.findElements(By.xpath("//a[@class='product-item-link']"));

        listaPatika.forEach(element -> {
            Assert.assertTrue(element.getText().contains("ADIDAP"), "NIJE DOBRO: " + element.getText());
            //NE VALJA ASERTACIJA, IZBACUJE SAMO JEDAN ELEMENT KAD JE POGRESNO ASERTOVANO
        });

    }
}
