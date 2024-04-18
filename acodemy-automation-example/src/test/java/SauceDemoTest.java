import com.github.javafaker.Faker;
import lombok.extern.java.Log;
import lv.acodemy.page_object.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.time.Duration;

import static lv.acodemy.utils.ConfigurationProperties.getConfiguration;
import static lv.acodemy.utils.Constants.SAUCE_DEMO;
import static lv.acodemy.utils.Constants.THANK_YOU_FOR_ORDER_MESSAGE;
import static lv.acodemy.utils.DriverManager.*;
import static org.assertj.core.api.Assertions.assertThat;


@Log
public class SauceDemoTest {

    AuthorizationPage authorizationPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutInformationOverviewPage checkoutInformationOverview;
    CheckoutCompletePage checkoutCompletePage;
    Header header;
    WebDriverWait waiter;

    Faker fakeData = new Faker();

    @BeforeMethod
    public void beforeTest(Method method) {
        setTestName(method.getName());
        authorizationPage = new AuthorizationPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutInformationPage = new CheckoutInformationPage();
        checkoutInformationOverview = new CheckoutInformationOverviewPage();
        checkoutCompletePage = new CheckoutCompletePage();
        header = new Header();
        waiter = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        getDriver().get(getConfiguration().getString(SAUCE_DEMO));
    }

    @Test
    public void purchaseItemFromInventoryTest() {
        log.info("Authorize with standard credentials");
        authorizationPage.authorize(
                getConfiguration().getString("saucedemo.login"),
                getConfiguration().getString("saucedemo.password"));

        log.info("Select item from inventory by name: Fleece Jacket");
        inventoryPage.selectItemByName("Fleece Jacket");
        assertThat(header.getShoppingCartBadge().getText()).isEqualTo("1");

        header.openCart();
        assertThat(cartPage.getCartItems().size()).isEqualTo(1);

        cartPage.clickCheckoutButton();
        checkoutInformationPage.fillInformationAndProceed(fakeData.funnyName().name(), fakeData.lebowski().character(), fakeData.address().zipCode());
        checkoutInformationOverview.submitOrder();
        assertThat(checkoutCompletePage.getHeaderMessage().getText()).isEqualTo(THANK_YOU_FOR_ORDER_MESSAGE);
    }

    @AfterMethod
    public void afterTest(ITestResult result) {
        String status = result.isSuccess() ? "passed" : "failed";
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("sauce:job-result=" + status);
        closeDriver();
    }
}
