package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"./src/test/resources/features/ScenarioTagsPractice.feature",
		"./src/test/resources/features/FeatureTagsPractice.feature"},
			tags = "@regression and @sanity")
public class FeatureTagsTest {

}
