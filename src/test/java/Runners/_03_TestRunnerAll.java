package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//bütün testleri çalıştıtrırı
@CucumberOptions(
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"}



)
public class _03_TestRunnerAll extends AbstractTestNGCucumberTests {
}
