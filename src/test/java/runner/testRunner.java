package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src\\test\\java\\features",
        glue = {"steps"},
        plugin = {"html:report/Reports.html"}
)
public class testRunner extends AbstractTestNGCucumberTests{
}
