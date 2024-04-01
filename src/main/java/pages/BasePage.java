package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    private By linkToObucaBy = By.xpath("//li[@id='category-node-3289']");
    private By obucaSportskaBy = By.xpath("//li[@id='category-node-33998']");
    private By obucaSportskaTenisBy = By.xpath("//a[@href='https://eplaneta.rs/obuca/sportska-obuca/patike-za-tenis.html']");
    private By searchButtonBy = By.id("search");
    private By SportIHobiBy = By.xpath("//li [@data-label= 'Sport i hobi']");
    private By addToCartButtonBy = By.xpath("//button [@id = 'product-addtocart-button']");


    By categoryFilterBy = By.xpath("//div [@class = 'filter-options-title']");
    By priceFromFilterBy = By.xpath("//input[@class = 'am-filter-price -from input-text']");
    By priceToFilterBy = By.xpath("//input[@class = 'am-filter-price -to input-text']");
    By priceFilterButtonBy = By.xpath("//button [@title = 'Apply filter']");
    By priceSliderBy = By.xpath("//div [@class = 'ui-slider-range ui-corner-all ui-widget-header']");
    By inventoryNameBy = By.xpath("//a [@class = 'product-item-link']");
    By inventoryItemPriceBy = By.xpath("//span [@class = 'price-container price-final_price tax weee']");
    By inventoryItemsBy = By.xpath("//li [@class = 'item product product-item']");
    By loaderBy = By.xpath("//div [@class = 'loader']");
    By productSortContainerBy = By.xpath("//select[@data-role= 'sorter']");


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(250));
    }

    public void waitVisibility(By elementLocator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementLocator));
    }

    public void waitVisibilityOf(By elementLocator) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementLocator)));
    }

    public void waitInvisibility(By elementLocator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));

    }

    public void clickElement(By elementLocator) {
        waitVisibility(elementLocator);
        driver.findElement(elementLocator).click();
    }

    public void writeText(By elementLocator, String text) {
        waitVisibility(elementLocator);
        driver.findElement(elementLocator).sendKeys(text);
    }

    public void goToCategoryPage(By categoryLocator) {
        driver.findElement(categoryLocator).click();
    }

    public void hoverOverKategorijeButton() {
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.xpath("//li[@class = 'level0 level-master-menu-item']")))
                .perform();
    }

    public void hoverOverCategory(By categoryNameBy) {
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(categoryNameBy)).perform();
    }

    public void hoverOverlinkToObucaSportska() {
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(obucaSportskaBy)).perform();
    }

    public void clickOnObucaSportskaTenisButton() {
        WebElement linkToObucaSportskaTenis = driver.findElement(obucaSportskaTenisBy);
        linkToObucaSportskaTenis.click();
    }

    public WebElement categoryElement(By categoryLocator) {
        return driver.findElement(categoryLocator);
    }

    public By getLinkObucaSportskaBy() {
        return obucaSportskaBy;
    }

    public By getLinkObucaSportskaTenisBy() {
        return obucaSportskaTenisBy;
    }

    public By getSportIHobiBy() {
        return SportIHobiBy;
    }

    public By getAddToCartButtonBy() {
        return addToCartButtonBy;
    }

    public void searchForSomething(String searchTerm) {
        WebElement searchField = driver.findElement(searchButtonBy);
        searchField.sendKeys(searchTerm);

        WebElement searchButton = driver.findElement(By.xpath("//button[@class= 'action search']"));
        searchButton.click();
    }

    public void kategorijaFilter(By elementLocator) {
        waitVisibilityOf(categoryFilterBy);
        WebElement kategorijaFilter = driver.findElement(categoryFilterBy);
        waitVisibility(elementLocator);
        WebElement podKategorijaFilter = kategorijaFilter.findElement(elementLocator);
        podKategorijaFilter.click();
    }

    public void priceRange(String from, String to) {

        waitVisibility(priceSliderBy);

        WebElement fromFilter = driver.findElement(priceFromFilterBy);
        fromFilter.clear();
        fromFilter.sendKeys(from);
        waitVisibility(priceSliderBy);

        WebElement toFilter = driver.findElement(priceToFilterBy);
        toFilter.clear();
        toFilter.sendKeys(to);
        waitVisibility(priceSliderBy);

        waitVisibility(priceFilterButtonBy);
        clickElement(priceFilterButtonBy);
    }

    public void waitForLoader() {
        waitVisibilityOf(loaderBy);
        waitInvisibility(loaderBy);
    }

    public WebElement selectRandomWebElement(By elementLocator) {
        List<WebElement> webElementList = driver.findElements(elementLocator);
        if (webElementList.size() == 0) {
            throw new SkipException("No available items in store!");
        }
        Random random = new Random();
        int size = webElementList.size();
        int selection = random.nextInt(size);
        return webElementList.get(selection);
    }
}
