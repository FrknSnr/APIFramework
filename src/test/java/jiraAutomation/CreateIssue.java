package jiraAutomation;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CreateIssue {

    //Add comment
    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:8080/";

        // Login
        SessionFilter session = new SessionFilter();
        String response = given().header("Content-Type", "application/json").
                body("{ \"username\": \"frknsnr57\"," +
                        " \"password\": \"1200571996\" }").
                log().all().filter(session).when().post("rest/auth/1/session").
                then().log().all().extract().response().asString();


        // Add Comment
        given().
                pathParam("key", "10303").
                log().all().
                header("Content-Type", "application/json").body("{ \n" +
                        "\"body\" : \"This is how we do !\",\n" +
                        "\"visibility\" : {\n" +
                        "\t\t\t\"type\" : \"role\",\n" +
                        "\t\t\t\"value\":\"Administrators\"\t\n" +
                        "\t\t\t}\n" +
                        "}").filter(session).when().post("rest/api/2/issue/{key}/comment").
                then().log().all().assertThat().statusCode(201).extract().response().asString();


        // Add Attachment  "errorMessages": ["You do not have permission to create attachments for this issue."]

        //curl -D- -u {USER}:{PASSWORD} -H "X-Atlassian-Token: nocheck" -H "X-ExperimentalApi: opt-in" -F "file=@{/path/to/file/test3.txt}" -X POST https://INSTANCE.atlassian.net/rest/servicedeskapi/servicedesk/{SERVICE_DESK_ID}/attachTemporaryFile
//        given().header("X-Atlassian-Token", "nocheck").filter(session).
//                pathParam("key", "10303").
//                header("Content-Type", "multipart/form-data").
//                multiPart("file", new File("jira.txt")).
//                when().post("rest/api/2/issue/{key}/attachments").
//                then().log().all().assertThat().statusCode(200);

          // Get Issue
        String getDetails = given().filter(session).
                pathParam("key","10303").log().all().
                queryParam("fields","comment").
                when().get("rest/api/2/issue/{key}").
                then().log().all().extract().response().asString();
        System.out.println(getDetails);
    }
}