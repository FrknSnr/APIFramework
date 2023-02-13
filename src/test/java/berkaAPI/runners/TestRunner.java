package berkaAPI.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/berkaAPI/features"
        , plugin = "json:target/jsonReports/cucumber-report.json"
        , glue = {"berkaAPI/stepDefinitions"}
        , tags = "@Register")

public class TestRunner {

}
