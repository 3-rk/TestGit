package cucumberTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"Feature"}
        , glue = {"stepDefinition"}
        ,plugin = {"pretty", "html:target/cucumber"}
        , monochrome = true

)
public class TestRunner {

}