package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\features",
		glue="src\\test\\java\\stepdefinitions",
		plugin = {"pretty", "html:target/cucumber-reports.html"},
		monochrome = true,
		dryRun = true
		
		)
public class TestRunner {

	
	
}
