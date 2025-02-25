package tests;


import org.testng.annotations.Test;
import pages.LandingPage;

public class LandingScreenTests extends BaseTest {


    @Test
    public void addToCart() throws InterruptedException {
        new LandingPage().searchItem("Iphone")
                .pressEnterForSearch()
                .getPageTitle()
                .getALlSearchResultElement().get(1).click();
        new LandingPage()
                .enterIntoProductDescriptionPage("search?q")
                .clickOnAddToCart();
    }
}
