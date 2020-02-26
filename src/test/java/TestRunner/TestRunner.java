
package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Feature"}
        , glue = {"src/test/java/stepDefinition"}
        , plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
        , monochrome = true

)
public class TestRunner {

}