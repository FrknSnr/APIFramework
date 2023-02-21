package reqresCreateAPI.resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {


    public RequestSpecification reqSpec() throws IOException {

        return new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI")).
                setContentType(ContentType.JSON).build();
    }

    public String getGlobalValue(String key) throws IOException {

        String path = "C:\\Users\\HP\\Desktop\\workspace\\APIFramework\\src\\test\\java\\reqresCreateAPI\\resources\\global.properties";
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream(path);
        prop.load(file);
        return prop.getProperty(key);
    }
}
