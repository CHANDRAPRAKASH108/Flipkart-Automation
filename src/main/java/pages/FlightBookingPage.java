package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlightBookingPage extends BasePage{

    private static final By flight_landing_element = By.xpath("//img[@alt = 'Flight Bookings']");
    private static final By depart_city_element = By.name("0-departcity");
    private static final By arrival_city_element = By.name("0-arrivalcity");
    private static final By search_flight_element = By.xpath("//button[span[text()='SEARCH']]");
    private static final String flight_city_element_dropdown = "//div[@class ='Reem3Q PNc-Ga _92tk+3']//div[@class='_98hP1j']//div[1]//div/span[contains(text(),'%s')]";

    private void selectFlightCity(String cityName){
        String xpath = String.format(flight_city_element_dropdown, cityName);
        List<WebElement> cityElement = DriverManager.getDriver().findElements(By.xpath(xpath));
        cityElement.get(0).click();
    }

    public FlightBookingPage clickFlightIcon(){
        clickElement(flight_landing_element, WaitStrategy.CLICKABLE);
        return this;
    }

    public FlightBookingPage enterValueForDepartureCity(String departCity){
        sendKeys(depart_city_element, WaitStrategy.CLICKABLE, departCity);
        selectFlightCity(departCity);
        return this;
    }

    public FlightBookingPage enterValueForArrivalCity(String arrivalCity){
        sendKeys(arrival_city_element, WaitStrategy.CLICKABLE, arrivalCity);
        selectFlightCity(arrivalCity);
        return this;
    }

    public FlightBookingPage clickOnSearch(){
        clickElement(search_flight_element, WaitStrategy.CLICKABLE);
        return this;
    }
}
