package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class LandingPage extends BasePage {

    private static final By search_box_element = By.name("q");
    private static final By all_search_result_element = By.xpath("//div[@class='KzDlHZ']");
    private static final By add_to_cart_element = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]");
    private static final By cart_icon_element = By.xpath("//a[contains(@href, 'viewcart')]");

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
        WebElement addToCartButton = DriverManager.getDriver().findElement(add_to_cart_element);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(addToCartButton).click().perform();
        return this;
    }

    public LandingPage enterIntoProductDescriptionPage(String windowHandleSearchIdentifier) throws InterruptedException {
        switchWindowHandle(windowHandleSearchIdentifier);
        Thread.sleep(5000);
        return this;
    }

    public LandingPage clickOnCartIcon() throws InterruptedException {
        clickElement(cart_icon_element, WaitStrategy.CLICKABLE);
        Thread.sleep(5000);
        return this;
    }
}
