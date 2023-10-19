package cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/cucumber/features/Login.feature",
        glue = "cucumber/stepDef/Login",
        plugin = {"html:target/HTML_report.html"}
)

public class RunLogin {
}
