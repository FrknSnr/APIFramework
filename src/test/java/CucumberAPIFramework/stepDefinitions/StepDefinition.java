package CucumberAPIFramework.stepDefinitions;

import static org.junit.Assert.*;

import CucumberAPIFramework.resources.APIResources;
import CucumberAPIFramework.resources.TestDataBuild;
import CucumberAPIFramework.resources.Utils;
import bodyClassses.AddPlace;
import bodyClassses.Location;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StepDefinition extends Utils {
    TestDataBuild testDataBuild = new TestDataBuild();
    RequestSpecification response;
    ResponseSpecification respSpec;
    Response res;
    static String place_Id ;
    
    @Given("Add Place Payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {
        response = given().spec(requestSpecification())
                .body(testDataBuild.addPlacePayload(name,language,address));

    }
    @When("user calls {string} with {string} http request")
    public void user_calls_with_post_http_request(String resources, String method) {
        APIResources resourceAPI = APIResources.valueOf(resources);
        System.out.println(resourceAPI.getResource());
//        respSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        if (method.equalsIgnoreCase("post")) {
            res = response.when().post(resourceAPI.getResource());
        }
        else if (method.equalsIgnoreCase("get")){
            res = response.when().get(resourceAPI.getResource());
        }
    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Object expectedCode) {
        assertEquals(res.getStatusCode(),expectedCode);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String expectedValue) {
        assertEquals(getJsonPath(res,key),expectedValue );
    }
    @Then("verify place_Id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String name, String resource) throws IOException {
        place_Id = getJsonPath(res,"place_id");
        response = given().spec(requestSpecification()).queryParam("place_id", place_Id);
        user_calls_with_post_http_request(resource,"get");
        String responseName = getJsonPath(res,"name");
        assertEquals(responseName,name);
    }
    @Given("Delete Place payload")
    public void delete_place_payload() throws IOException {
        response = given().spec(requestSpecification()).body(testDataBuild.deletePlacePayload(place_Id));
    }

}
