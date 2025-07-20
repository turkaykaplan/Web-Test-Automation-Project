package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;
import static java.nio.file.Files.writeString;
import static java.nio.file.Path.of;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class ProductPage extends BasePage{

    @FindBy(css = "span[class='o-productDetail__description']")
    WebElement title;

    @FindBy(xpath = "//*[@class='m-price__new']")
    WebElement price;

    @FindBy(id = "addBasket")
     WebElement addToCart;

    @FindBy(xpath = "/html/body/header/div/div/div[3]/div/a[3]")
     WebElement goToCart;

    @FindBy(xpath = "//*[@id=\"sizes\"]/div/span[2]")
     WebElement selectSize;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void saveInfo() throws IOException {
        writeString(of("product-info.txt"), title.getText()+" | "+price.getText()+"\n", CREATE, APPEND);
    }

    public void addProduct(){
        selectSize.click();
        addToCart.click();
    }

    public String getProductPagePrice(){
        return price.getText();
    }

    public void cartWay(){
        goToCart.click();
    }
}