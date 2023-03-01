package reqresUpdateAPI.stepDefinitions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import reqresUpdateAPI.pojoClasses.UpdatedUserDeserialize;
import reqresUpdateAPI.resources.UpdateUserUtils;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class UpdateStepDef {

    private static RequestSpecification baseReq;
    private static Response response;
    private static int count = 0;
    private static ObjectMapper om;
    UpdatedUserDeserialize[] updatedUsers ;

    @Given("User new {string} and {string}")
    public static void user_new_and(String name, String job) throws IOException {
        baseReq = UpdateUserUtils.setReq(name, job);
    }

    @When("we call put api")
    public static void we_call_put_api() throws IOException {
        response = UpdateUserUtils.setPutAPI(baseReq);
    }

    @Then("the API call got success with the status {int}")
    public void the_api_call_got_success_with_the_status(int statusCode) {
        assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("verify if the name and job is changed")
    public void verify_if_the_name_and_job_is_changed() throws JsonProcessingException {
        om = UpdateUserUtils.getObjectMapper();
        updatedUsers = om.readValue(response.asString(),UpdatedUserDeserialize[].class);

        System.out.println(updatedUsers[count].getUpdatedAt());

//        UpdatedUserDeserialize[] user = new UpdatedUserDeserialize[4];
//        user[count] = om.readValue(response.asString(), UpdatedUserDeserialize.class);
//        System.out.println(user[count].getJob() + " | " + user[count].getName() + " | " + user[count].getUpdatedAt());
//        System.out.println("************--------------*************");
//        count++;
    }
}

