package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;

public class CreateUser {
    private static final String BASE_URL = "https://reqres.in/";
    private static Response response;
    RequestSpecification request;
    HashMap<String,Object> map=new HashMap<>();
    @Given("I set a POST employee service endpoint")
    public void iSetAPOSTEmployeeServiceEndpoint() {
        map.put("name","morpheus");
        map.put("job","leader");
        RestAssured.baseURI = BASE_URL;
        request = RestAssured.given().log().all();
        request.body(map).log().all();
    }

    @When("I set request Header")
    public void iSetRequestHeader() {
        Header header= new Header("Content-Type","application/json");
        request.header(header);
    }

    @And("Send a HTTP request")
    public void sendAHTTPRequest() {
       response= request.post("/api/users");
    }


    @Then("I receive a valid responsecode {int}")
    public void iReceiveAValidResponsecodeStatuscode(int statuscode) {
        Assert.assertEquals(statuscode,response.getStatusCode());
    }
}
