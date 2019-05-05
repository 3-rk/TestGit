package cucumberTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/Feature"
        ,glue={"java/cucumberTest/stepDefinition"}
        ,plugin = {"pretty", "html:target/cucumber"}
        , dryRun = true


)
public class TestRunner {

}