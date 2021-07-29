package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".\\src\\test\\resources\\Features",
        glue="stepDefinitions",
        dryRun=false,
        monochrome=true,
        plugin= {"pretty","html:target/reports/report.html"},
		tags= "@mixdatalogin"
		)
public class TestRun {

}
