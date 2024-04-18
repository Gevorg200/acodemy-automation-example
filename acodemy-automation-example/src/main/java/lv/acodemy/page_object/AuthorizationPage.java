package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;


public class AuthorizationPage {

    @FindBy(how = How.XPATH, xpath = "//input[@data-test='username']")
    @Getter
    private WebElement usernameField;

    @FindBy(how = How.XPATH, xpath = "//input[@data-test='password']")
    @Getter
    private WebElement passwordField;

    @FindBy(how = How.XPATH, xpath = "//input[contains(@class,'submit-button')]")
    @Getter
    private WebElement submitButton;

    WebDriverWait waiter = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));

    public AuthorizationPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void authorize(String username, String password) {
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getSubmitButton().click();

        waiter.until(ExpectedConditions.invisibilityOf(submitButton));
    }

    private WebElement getPasswordField() {
        return null;
    }

    private WebElement getUsernameField() {
        return null;
    }

    public WebElement getSubmitButton() {
        return null;
    }
}

