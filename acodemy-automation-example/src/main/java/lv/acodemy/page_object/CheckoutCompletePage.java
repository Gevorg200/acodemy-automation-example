package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {

    @FindBy(how = How.CLASS_NAME, className = "complete-header")
    @Getter
    WebElement headerMessage;

    public CheckoutCompletePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}
