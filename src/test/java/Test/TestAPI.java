package Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TestAPI {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";
        Response response = given().body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}").when().post("/api/users").
                then().assertThat().statusCode(201)
                .extract().response();

    }
}
