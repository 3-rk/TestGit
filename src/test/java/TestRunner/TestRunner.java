
package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Feature"}
        , glue = {"src/test/java/stepDefinition"}
        , plugin = {"pretty", "html:target/cucumber"}
        , monochrome = true
//        ,dryRun = false
)
public class TestRunner {

}