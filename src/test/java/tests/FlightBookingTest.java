package tests;

import annotation.FrameworkAnnotation;
import enums.CategoryType;
import org.apache.logging.log4j.Level;
import org.testng.annotations.Test;
import pages.FlightBookingPage;
import utils.DataProviderUtils;

import java.util.Map;

public class FlightBookingTest extends BaseTest{


    @Test(dataProviderClass = DataProviderUtils.class, dataProvider = "getBookFlightData")
    @FrameworkAnnotation(authors = {"Prakash"}, categories = {CategoryType.SANITY})
    public void bookFlight(Map<String, String> dataMap) {
        logger.log(Level.ALL, "Started executing book flight tests");
        new FlightBookingPage().clickFlightIcon()
                .enterValueForDepartureCity(dataMap.get("departcity"))
                .enterValueForArrivalCity(dataMap.get("arrivalcity"))
                .clickOnSearch();
    }
}
