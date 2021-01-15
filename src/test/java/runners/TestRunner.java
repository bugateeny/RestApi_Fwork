package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber/cucumber-reports.json",
                "junit:target/cucumber.xml",
        },
        features = {"src/main/resources/features_Files"},
        glue = {"step_Definitions"},
        monochrome = true,
        tags = "@Regression"

)

//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/main/resources/features_Files",
//        plugin = {"html:target/ReportsDestinations","pretty"},
//        tags = "@Regression", glue = {"step_Definitions"})

public class TestRunner {


}
