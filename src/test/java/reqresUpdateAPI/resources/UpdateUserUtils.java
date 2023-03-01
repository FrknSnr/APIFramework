package reqresUpdateAPI.resources;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import reqresUpdateAPI.pojoClasses.UpdateDataBody;
import reqresUpdateAPI.pojoClasses.UpdateUser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class UpdateUserUtils {

    private static ObjectMapper om = new ObjectMapper();

    public static ObjectMapper getObjectMapper(){
        om.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY,true);
        return om ;
    }

    public static Response setPutAPI(RequestSpecification baseReq) throws IOException {
       return baseReq.when().put(getProperty("updateAPI")).then().extract().response();
    }

    public static UpdateUser getPayloadObject(String name, String job){
        return UpdateDataBody.updateUserPayload(name,job);
    }
    public static RequestSpecification setReq(String name, String job) throws IOException {
        String body = om.writeValueAsString(getPayloadObject(name,job));
        return given().spec(getBaseReq()).body(body);
    }

    public static RequestSpecification getBaseReq() throws IOException {
        RequestSpecification req = new RequestSpecBuilder().setBaseUri(getProperty("baseURI")).
                setContentType(ContentType.JSON).build();
        return req;
    }

    public static String getProperty(String key) throws IOException {

        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\HP\\Desktop\\workspace\\APIFramework\\src\\test\\java\\reqresUpdateAPI\\resources\\global.properties");
        prop.load(file);
        file.close();
        return prop.getProperty(key);
    }

}
