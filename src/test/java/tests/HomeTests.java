package tests;


import driver.DriverManager;
import org.testng.annotations.Test;
public class HomeTests extends BaseTest {


    @Test
    public void firstTest(){
        String title = DriverManager.getDriver().getTitle();
        System.out.println(title);
    }
}
