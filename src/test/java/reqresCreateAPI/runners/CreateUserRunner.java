package reqresCreateAPI.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/reqresCreateAPI/features",
        glue = {"reqresCreateAPI/stepDefinitions"}
)
public class CreateUserRunner {

}
