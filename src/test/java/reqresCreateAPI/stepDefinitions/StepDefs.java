package reqresCreateAPI.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import reqresCreateAPI.resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class StepDefs extends Utils {

    RequestSpecification req;
    Response resPost;

    @Given("User {string} and {string}")
    public void userAnd(String name, String job) throws IOException {

        req = given().spec(reqSpec()).body()
        req = given().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");

    }

    @When("we call Post API with post http request")
    public void weCallPostAPIWithPostHttpRequest() {
        resPost = req.when().post("/api/users");

    }

    @Then("the API call got success with status {int}")
    public void theAPICallGotSuccessWithStatus(int statusCode) {
        assertEquals(resPost.getStatusCode(), statusCode);
    }

    @And("verify the users' {string} and {string}")
    public void verifyTheUsersAnd(String name, String job) {
        User[] users = resPost.as(User.class);

    }
}
