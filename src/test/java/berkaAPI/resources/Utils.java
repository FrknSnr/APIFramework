package berkaAPI.resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {



    public RequestSpecification requestSpecification1() throws IOException {

        return new RequestSpecBuilder()
                .setBaseUri(getGlobalValue1("baseUrl"))
                .setContentType(ContentType.JSON).build();

    }

    public String getGlobalValue1(String key) throws IOException {

        Properties prop1 = new Properties();
        FileInputStream fis1 = new FileInputStream("C:\\Users\\HP\\Desktop\\workspace\\APIFramework\\src\\test\\java\\berkaAPI\\resources\\global.properties");
        prop1.load(fis1);
        return prop1.getProperty(key);
    }
}
