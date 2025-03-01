package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class FlightBookingPage extends BasePage{

    private static final By flight_landing_element = By.xpath("//img[@alt = 'Flight Bookings']");
    private static final By depart_city_element = By.name("0-departcity");
    private static final By arrival_city_element = By.name("0-arrivalcity");
    private static final By search_flight_element = By.xpath("//button[span[text()='SEARCH']]");

    public FlightBookingPage clickFlightIcon(){
        clickElement(flight_landing_element, WaitStrategy.CLICKABLE);
        return this;
    }

    public FlightBookingPage enterValueForDepartureCity(String departCity){
        sendKeys(depart_city_element, WaitStrategy.CLICKABLE, departCity);
        return this;
    }

    public FlightBookingPage enterValueForArrivalCity(String arrivalCity){
        sendKeys(arrival_city_element, WaitStrategy.CLICKABLE, arrivalCity);
        return this;
    }

    public FlightBookingPage clickOnSearch(){
        clickElement(search_flight_element, WaitStrategy.CLICKABLE);
        return this;
    }
}
