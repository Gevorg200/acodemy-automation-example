package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class InventoryPage {

    @FindBy(how = How.CLASS_NAME, className = "inventory_item")
    @Getter
    List<WebElement> inventoryElements;

    private final By addToCartButton = By.xpath(".//div[@class='pricebar']//button");

    public InventoryPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void selectItemByName(String itemName) {
        for (int i = 0; i < getInventoryElements().size(); i++) {
            if(inventoryElements.get(i).getText().contains(itemName)) {
                inventoryElements.get(i).findElement(addToCartButton).click();
                break;
            }
        }
    }
}
