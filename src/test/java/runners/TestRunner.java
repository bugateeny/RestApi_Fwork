package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber/cucumber.json",
        },
        features = "src/main/resources/features_Files",
        monochrome = true,
        tags = "@Regression",
        glue = {"step_Definitions"})


//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/main/resources/features_Files",
//        plugin = {"html:target/ReportsDestinations","pretty"},
//        tags = "@Regression", glue = {"step_Definitions"})

public class TestRunner {


}
