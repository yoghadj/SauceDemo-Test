package cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/cucumber/features/AddProduct.feature",
        glue = "cucumber/stepDef/AddRemove",
        plugin = {"html:target/HTML_report.html"}
)

public class RunAddProduct {
}
