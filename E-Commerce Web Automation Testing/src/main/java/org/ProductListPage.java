package org;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductListPage extends BasePage {
    public ProductListPage(WebDriver driver) {
    super(driver);
    }

    @FindBy(xpath = "//div[contains(@data-productid, '1694992')]")
    private WebElement product;

    public void selectProduct(){
        product.click();
    }
}