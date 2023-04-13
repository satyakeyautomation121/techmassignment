package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class UsersList {
    private static final String BASE_URL = "https://reqres.in/";
    private static Response response;
    RequestSpecification request;
    @Given("A list of users available")
    public void aListOfUsersAvailable() {
        RestAssured.baseURI = BASE_URL;
        request = RestAssured.given().log().all();
        request.header("Content-Type", "application/json");
    }

    @When("Client requests to get users")
    public void clientRequestsToGetUsers() {
        response=request.get("api/users/2");

    }

    @Then("The Response code should be {int}")
    public void theResponseCodeShouldBe(int statuscode) {
        Assert.assertEquals(statuscode,response.getStatusCode());
    }


}
