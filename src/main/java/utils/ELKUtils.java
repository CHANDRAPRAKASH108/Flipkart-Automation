package utils;


import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ELKUtils {

    private ELKUtils(){}

    public static void sendTestResultToELK(String testname, String status){
        Map<String, String> prepareRequest = new HashMap<>();
        prepareRequest.put("testname", testname);
        prepareRequest.put("status", status);
        prepareRequest.put("execution_time", LocalDateTime.now().toString());
        Response response = given()
                .header("Content-Type", "application/json")
                .log()
                .all()
                .body(prepareRequest)
                .post("http://localhost:9200/fas/testresult");
        Assert.assertEquals(response.statusCode(), 201);
        response.prettyPrint();
    }
}
