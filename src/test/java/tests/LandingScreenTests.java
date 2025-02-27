package tests;


import org.testng.annotations.Test;
import pages.LandingPage;
import utils.DataProviderUtils;

import java.util.Map;

public class LandingScreenTests extends BaseTest {


    @Test(dataProviderClass = DataProviderUtils.class, dataProvider = "getAddToCartData")
    public void addToCart(Map<String, String> dataMap) throws InterruptedException {
        new LandingPage().searchItem(dataMap.get("searchtext"))
                .pressEnterForSearch()
                .getPageTitle()
                .getALlSearchResultElement().get(0).click();
        new LandingPage()
                .enterIntoProductDescriptionPage("search?q")
                .clickOnAddToCart();
    }
}
