package reqresCreateAPI.stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import reqresCreateAPI.pojoClasses.DataBuild;
import reqresCreateAPI.pojoClasses.NewUser;
import reqresCreateAPI.resources.CreateUserUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class CreateUserStepDefs extends CreateUserUtils {

    DataBuild dataBuild;
    RequestSpecification req;
    Response response;
    static int count = 0;

    @Given("User {string} and {string}")
    public void userAnd(String name, String job) throws IOException {
        dataBuild = new DataBuild();
        req = given().spec(reqSpec()).body(dataBuild.createUser(name, job));
    }

    @When("we call Post API with post http request")
    public void weCallPostAPIWithPostHttpRequest() {
        response = req.when().post("/api/users").then().extract().response();
    }

    @Then("the API call got success with status {int}")
    public void theAPICallGotSuccessWithStatus(int statusCode) {
        assertEquals(response.getStatusCode(), statusCode);
    }

    @And("verify the users' {string} and {string}")
    public void verifyTheUsersAnd(String name, String job) throws JsonProcessingException {
//        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
//        String response = resPost.then().extract().response().toString();
//        NewUser[] newUsers = objectMapper.readValue(response,NewUser[].class);
//        objectMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        ObjectMapper objectMapper = new ObjectMapper();
        NewUser[] newUsers = new NewUser[4];
        newUsers[count] = objectMapper.readValue(response.asString(),NewUser.class);
        System.out.println(newUsers[count].getName() + "\n" + newUsers[count].getId() +"\n" + newUsers[count].getCreatedAt());
        System.out.println("------------**************----------------");
//        NewUser newUsers = objectMapper.readValue(response.asString(), NewUser.class);
//        assertEquals(newUsers.getName(), name);
//        assertEquals(newUsers.getJob(), job);
//        System.out.println(newUsers.getId());
//        System.out.println(newUsers.getCreatedAt());

//        NewUsers newUsers = objectMapper.readValue(response.asString(), NewUsers.class);
//        System.out.println(newUsers.getNewUsers().get(0).getId());

                count++;
    }
}

