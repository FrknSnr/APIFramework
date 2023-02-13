package Test;


import com.fasterxml.jackson.databind.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ObjectMapperTest {

//    String json = "\"{\n" +
//            "    \"id\": 123,\n" +
//            "    \"holderName\":\"frkn\"    \n" +
//            "         }\" ";
//    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void show() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        BankAccount bankAccount = new BankAccount(123, "Frkn");
        objectMapper.writeValue(new File("src/main/resources/bankAccount.json"), bankAccount);

        String asString = objectMapper.writeValueAsString(bankAccount);
        System.out.println(asString);

        String jsonString = "{" +
                "\"id\":543," +
                "\"holderName\":\"Frkn\"" +
                "}";
        BankAccount bankAccount2 = objectMapper.readValue(jsonString, BankAccount.class);
        System.out.println(bankAccount2.getId());
//        BankAccount o = new BankAccount();
//        o.setId(4);
//        System.out.println(o.getId());
    }
}
