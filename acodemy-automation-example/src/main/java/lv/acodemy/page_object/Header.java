package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Header {

    @FindBy(how = How.CLASS_NAME, className = "shopping_cart_badge")
    @Getter
    private WebElement shoppingCartBadge;

    @FindBy(how = How.CLASS_NAME, className = "shopping_cart_link")
    @Getter
    private WebElement cartLink;

    public Header() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void openCart() {
        getCartLink().click();
    }
}
