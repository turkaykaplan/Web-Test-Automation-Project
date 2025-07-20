package org;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="quantitySelect0-key-0")
    public WebElement qtyValue;

    public int getQuantity() {
        return Integer.parseInt(qtyValue.getAttribute("value"));
    }

    @FindBy(css = "li[class='m-orderSummary__item -grandTotal'] > span[class='m-orderSummary__value']")
    WebElement cartPagePrice;

    public String getCartPagePrice() {
        return cartPagePrice.getText();
    }

    @FindBy(xpath = "//*[@id=\"removeCartItemBtn0-key-0\"]")
    public WebElement removeButton;

    public void removeProduct() throws InterruptedException {
        Thread.sleep(1000);
        removeButton.click();
    }
}