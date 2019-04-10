package testcases;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class SampleGetTest1 {

    @Test
    public void verifyStatusCode()
    {
        //Specify the base URL to the RESTful web service
        RestAssured.baseURI = "http://localhost:9000/users";

        //Get the RequestSpecification of the request that you want to sent to the server
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);

        //Get response body and put assertion
        String responseBody = response.getBody().asString();
        System.out.println("Response Body =>  \n" + responseBody);
        int responseCode = response.getStatusCode();
        System.out.println("\nResponse code =>  \n" + responseCode);
        Assert.assertEquals(responseCode,200);
    }

    public void verifycontentType()
    {
        RestAssured.baseURI = "http://localhost:9000/users";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);

        // Get headers and put assertion
        System.out.println("\nAll Headers =>  \n" + response.getHeaders());
        String contentType = response.getHeader("Content-Type");
        Assert.assertEquals(contentType,"application/json");
    }
}