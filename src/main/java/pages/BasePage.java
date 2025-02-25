package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import factory.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class BasePage {

    protected void clickElement(By by, WaitStrategy waitStrategy){
        WebElement element = ExplicitWaitFactory.explicitWaitForElement(by, waitStrategy);
        element.click();
    }

    protected void sendKeys(By by, WaitStrategy waitStrategy, String values){
        WebElement element = ExplicitWaitFactory.explicitWaitForElement(by, waitStrategy);
        element.sendKeys(values);
    }

    protected void getTitle(){
        System.out.println(DriverManager.getDriver().getTitle());
    }

    protected void pressEnter(By by){
        WebElement element = ExplicitWaitFactory.explicitWaitForElement(by, WaitStrategy.CLICKABLE);
        element.sendKeys(Keys.ENTER);
    }

    protected List<WebElement> getALlElement(By by){
        return DriverManager.getDriver().findElements(by);
    }

    public void switchWindowHandle(String windowHandleSearchIdentifier) {
        Set<String> windowHandles = DriverManager.getDriver().getWindowHandles();
        for (String window : windowHandles) {
            String currentUrl = DriverManager.getDriver().switchTo().window(window).getCurrentUrl();
            if (currentUrl != null && !currentUrl.contains(windowHandleSearchIdentifier)) {
                break;
            }
        }
    }
}
