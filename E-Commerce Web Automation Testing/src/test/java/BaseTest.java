import io.github.bonigarcia.wdm.WebDriverManager;
import org.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    static WebDriver driver;
    static BasePage basePage;
    static HomePage homePage;
    static ProductListPage productListPage;
    static ProductPage productPage;
    static CartPage cartPage;
    static Logger log = LogManager.getLogger(HomePage.class);

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.beymen.com/tr");
        driver.manage().window().maximize();
        log.info("Site açıldı.");
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        productListPage = new ProductListPage(driver);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}