package lv.acodemy.step_definitions;

import io.cucumber.java.en.Given;

import static lv.acodemy.utils.ConfigurationProperties.getConfiguration;
import static lv.acodemy.utils.Constants.SAUCE_DEMO;
import static lv.acodemy.utils.DriverManager.getDriver;

public class CommonStepDefs {

    @Given("user open main page")
    public void user_open_main_page() {
        getDriver().get(getConfiguration().getString(SAUCE_DEMO));
    }
}
