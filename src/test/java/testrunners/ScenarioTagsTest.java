package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/features/ScenarioTagsPractice.feature",
                 tags = "@smoke and not @sanity or @regression")
public class ScenarioTagsTest {

}
