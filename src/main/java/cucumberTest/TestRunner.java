package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/Feature"
        ,glue={"java/cucumberTest/stepDefinition"}
        ,plugin = {"pretty", "html:target/cucumber"}


)
public class TestRunner {

}