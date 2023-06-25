package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//Cucumber
@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/features/LoginActitime.feature",
				glue = "stepdefinitions",
				plugin = {"pretty", "html:target/HTML/reports.html",
						"junit:JUNIT/junit.xml",
						"json:JSON/reports.json"})
public class ActitimeLoginTest {

}
