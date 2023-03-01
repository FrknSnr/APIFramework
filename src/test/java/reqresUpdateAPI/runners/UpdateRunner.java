package reqresUpdateAPI.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/reqresUpdateAPI/features/",
        glue = {"reqresUpdateAPI/stepDefinitions"},
        plugin = "json:target/jsonReports/cucumber-report.json"
)
public class UpdateRunner {
}
