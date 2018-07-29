package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Feature"
        ,glue={"src/main/java/stepDefinition"}
)
public class TestRunner {

}