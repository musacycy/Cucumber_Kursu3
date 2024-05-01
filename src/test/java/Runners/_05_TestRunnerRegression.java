package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(//or olduğunda herhangi biri varsa çalıştırır and olduğunda herikisininde olduğu searyolar çalışır
        tags = "@Regression or SmokeTest",// hangi senaryolarda bu etiket varsa onlar çalıştırılacak
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"}


)
public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
}// browser tipi vermek için rapora ek parametre eklemek için kullanacağız
