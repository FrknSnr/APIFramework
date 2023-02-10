package CucumberAPIFramework.stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        StepDefinition m = new StepDefinition();
        if (StepDefinition.place_Id == null) {
            m.add_place_payload_with("Frkn", "Espanol", "Europe");
            m.user_calls_with_post_http_request("AddPlaceAPI", "post");
            m.verify_place_id_created_maps_to_using("Frkn", "getPlaceAPI");
        }
    }
}
