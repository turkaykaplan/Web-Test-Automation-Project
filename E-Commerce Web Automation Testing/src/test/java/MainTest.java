import org.ProductPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class MainTest extends BaseTest {


    String productPagePrice;
    String cartPagePrice;


    @Test @Order(1)
    void verifyPageUrl()  {
     homePage.closeBanner();
     homePage.verifyHomePageUrl();

    }

    @Test @Order(2)
    void searchProduct() throws InterruptedException {
        Thread.sleep(500);
        homePage.runSearchScenario();
    }

    @Test @Order(3)
    void selectAProduct() throws InterruptedException {
     //   Thread.sleep(2000);
        productListPage.selectProduct();
    }

    @Test @Order(4)
    void saveProductInfo() throws Exception {
   //     Thread.sleep(2000);
        productPagePrice = productPage.getProductPagePrice();
        System.out.println("Fiyat: " + productPagePrice);
        productPage.saveInfo();
    }

    @Test @Order(5)
    void addCart() throws InterruptedException {
   //     Thread.sleep(2000);
        productPage.addProduct();
    }

    @Test @Order(6)
    void openCartPage() throws InterruptedException {
    //    Thread.sleep(2000);
        productPage.cartWay();
    }

    @Test @Order(7)
    void productPriceTest() throws InterruptedException {
       Thread.sleep(2000);
        cartPagePrice = cartPage.getCartPagePrice();
        System.out.println("Fiyat: " + cartPagePrice);
        assertAll(
                () -> assertEquals(productPagePrice, cartPagePrice, "Fiyatlar eşleşmiyor!")
        );
    }

    @Test @Order(8)
    public void increaseProductQuantity() throws InterruptedException {
    //    Thread.sleep(2000);
        driver.navigate().back();
      Thread.sleep(1000);
        productPage = new ProductPage(driver);
        productPage.addProduct();
     //   Thread.sleep(1000);
        productPage.cartWay();
    }

    @Test @Order(9)
    void testQuantity() throws InterruptedException {
    Thread.sleep(1000);
        assertEquals(2, cartPage.getQuantity(), "Adet 2 olmadı!");
    }

    @Test @Order(10)
    void remove() throws InterruptedException{
        cartPage.removeProduct();
        Thread.sleep(1000);
        assertTrue(driver.getPageSource()
                .contains("Sepetinizde Ürün Bulunmamaktadır"));

    }
}