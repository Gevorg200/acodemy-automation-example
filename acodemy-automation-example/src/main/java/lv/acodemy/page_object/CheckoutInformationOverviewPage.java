package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationOverviewPage {

    @FindBy(how = How.ID, id = "finish")
    @Getter
    WebElement finishButton;

    public CheckoutInformationOverviewPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void submitOrder() {
        getFinishButton().click();
    }


}
