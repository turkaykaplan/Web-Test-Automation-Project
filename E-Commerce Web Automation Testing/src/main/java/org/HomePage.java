package org;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.utils.ExcelUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class HomePage extends BasePage{
     static  String EXCEL = "src/test/resources/data.xlsx";
     static  String SHEET = "Sheet1";
     static  Logger log = LogManager.getLogger(HomePage.class);


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyHomePageUrl() {
        wait.until(ExpectedConditions.urlToBe(pageURL));
        log.info("URL kontrolü: beklenen='{}' - mevcut='{}'", pageURL, driver.getCurrentUrl());
        Assert.assertEquals("Home page URL’i beklenenden farklı!", pageURL, driver.getCurrentUrl());
    }

    @FindBy(xpath = "/html/body/header/div/div/div[2]/div/div/input")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"o-searchSuggestion__input\"]")
    public WebElement searchBox2;

    public void runSearchScenario() throws InterruptedException {
        Thread.sleep(500);
        searchBox.click();

        Thread.sleep(500);
        String word1 = ExcelUtils.readCell(EXCEL, SHEET, 0, 0); // [0,0]

        searchBox2.sendKeys(word1);
        Thread.sleep(500);

        searchBox2.clear();
        Thread.sleep(500);

        String word2 = ExcelUtils.readCell(EXCEL, SHEET, 0, 1); // [0,1]
        searchBox2.sendKeys(word2);

        Thread.sleep(500);
        searchBox2.sendKeys(Keys.ENTER);
    }

    public void closeBanner() {
        try {
            WebElement cookieButton = driver.findElement(By.id("onetrust-reject-all-handler"));
            cookieButton.click();
            WebElement gender = driver.findElement(By.id("genderManButton"));
            gender.click();
            System.out.println("Cookie is closed.");
        } catch (NoSuchElementException e) {
            System.out.println("Cookie alert does not seem.");
        }
    }
}
