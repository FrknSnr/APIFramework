package berkaAPI.stepDefinitions;

import berkaAPI.bodyClasses.DataBuild;
import berkaAPI.resources.APIResources1;
import berkaAPI.resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinitions extends Utils {
    RequestSpecification response1;
    DataBuild dataBuild = new DataBuild();
    Response res1;

    @Given("Add Client Payload with {string} and {string}")
    public void add_client_payload_with_and(String clientName, String clientEmail) throws IOException {
        response1 = given().spec(requestSpecification1()).
                body(dataBuild.addClientPayload(clientName, clientEmail));
    }

    @When("user calls {string} with post http request")
    public void user_calls_with_http_request(String resources) {
        APIResources1 resourseAPI1 = APIResources1.valueOf(resources);
        System.out.println(resourseAPI1);
        res1 = response1.when().post(resourseAPI1.getResource());
    }

    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Object int1) {
        assertEquals(res1.getStatusCode(), int1);
        JsonPath js = new JsonPath(res1.asString());
        System.out.println(js.getString("access_token"));
    }
}
