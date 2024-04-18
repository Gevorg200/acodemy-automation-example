import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GoogleTest {

    ChromeDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void googleTest() {
        driver.get("https://google.lv");

        // Click on Accept all
        driver.findElement(By.xpath("//div[text()='Accept all']//parent::button")).click();

        // Write input into a search input field
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("acodemy IT kursi");
        searchInput.sendKeys(Keys.ENTER);

        Assert.assertEquals(driver.getTitle(), "acodemy IT kursi - Google Search");
        assertThat(driver.getTitle()).contains("acodemy IT kursi");
    }

    @Test(description = "Login with standard user")
    public void successLoginTest() {

        // Task 1: Open saucedemo.com;
        driver.get("https://www.aucedemo.com");

        // Task 2: Define Element: username
        // And enter value: standard_user
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Task 3: Define Element: password
        // And enter password value;
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Task 4: Define Login button
        // And click on it;
        WebElement loginButton = driver.findElement(By.id("password"));
        loginButton.submit();

        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        assertThat(inventoryList.isDisplayed()).isTrue();
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
