package pages;

import driver.Driver;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class LandingPage extends BasePage {

    private static final By search_box_element = By.name("q");
    private static final By all_search_result_element = By.xpath("//div[@class='KzDlHZ']");
    private static final By add_to_cart_element = By.xpath("//button[.//span[contains(text(), 'Add to cart')]]");

    public LandingPage searchItem(String searchString) {
        sendKeys(search_box_element, WaitStrategy.CLICKABLE, searchString);
        return this;
    }

    public LandingPage getPageTitle() {
        getTitle();
        return this;
    }

    public LandingPage pressEnterForSearch() {
        pressEnter(search_box_element);
        return this;
    }

    public List<WebElement> getALlSearchResultElement() {
        return getALlElement(all_search_result_element);
    }

    public LandingPage clickOnAddToCart() throws InterruptedException {
        WebElement element = DriverManager.getDriver().findElement(add_to_cart_element);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        clickElement(add_to_cart_element, WaitStrategy.CLICKABLE);
        return this;
    }

    public LandingPage enterIntoProductDescriptionPage(String windowHandleSearchIdentifier) throws InterruptedException {
        switchWindowHandle(windowHandleSearchIdentifier);
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.presenceOfElementLocated(add_to_cart_element));
        return this;
    }
}
