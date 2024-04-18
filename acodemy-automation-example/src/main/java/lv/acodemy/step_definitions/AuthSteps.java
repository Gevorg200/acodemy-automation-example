package lv.acodemy.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lv.acodemy.page_object.AuthorizationPage;
import lv.acodemy.utils.ConfigurationProperties;
import lv.acodemy.utils.DriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthSteps {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    WebDriverWait waiter = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigurationProperties.getConfiguration().getInt("element.wait")));

    @When("user logs in with credentials: {string} and {string}")
    public void userLogsInWithCredentials(String username, String password) {
        authorizationPage.authorize(username, password);
    }

    @Then("user is authenticated")
    public void userIsAuthenticated() {
        waiter.until(ExpectedConditions.invisibilityOf(authorizationPage.getSubmitButton()));
    }
}
