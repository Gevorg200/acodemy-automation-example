package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    @FindBy(how = How.CLASS_NAME, className = "cart_item")
    @Getter
    List<WebElement> cartItems;

    @FindBy(how = How.ID_OR_NAME, id = "checkout")
    @Getter
    WebElement checkoutButton;

    public CartPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickCheckoutButton() {
        getCheckoutButton().click();
    }
}
