package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags ={"@search"},
        plugin = {"pretty",
        "html:target/default-cucumber-reports",
            "json:target/cucumber.json"},
        features = {"classpath:features"},
        glue={"step_defs"},
        dryRun = true
)
public class Runner {

}
