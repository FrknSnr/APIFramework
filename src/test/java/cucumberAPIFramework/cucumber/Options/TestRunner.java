package cucumberAPIFramework.cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/CucumberAPIFramework/features"
        , plugin = "json:target/jsonReports/cucumber-report.json"
        , glue = {"cucumberAPIFramework/stepDefinitions"}
        )
//, tags = "@DeletePlace"
public class TestRunner {


}
