package lv.acodemy.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import static lv.acodemy.utils.DriverManager.closeDriver;

@CucumberOptions(
        tags = "@smoke",
        features = {"src/test/resources/features"},
        glue = {"lv.acodemy.step_definitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    public void aferTest(ITestResult result) {
        closeDriver();
    }
}
