package testrun;

import helpers.SupportFunctions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class AddingToCartTest {

    String url = "https://bee.pl";
    WebDriver driver;

    public WebElement fluentWait(final By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(2000))
                .withTimeout(Duration.ofSeconds(15))
                .ignoring(NoSuchElementException.class);
        WebElement foo = wait.until(new Function<>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return foo;
    };

    public void waitForInvisibility(String id) {
        WebElement ele = driver.findElement(By.id(id));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterEach
    public void driverQuit() {
        driver.quit();
    }

    @Test
    public void isMainPageAvailable() throws Exception {
        String mainPageHeader = "header";

        fluentWait(By.id(mainPageHeader));
    }

    @Test
    public void isProductOnTheList() throws Exception {
        String productName = "Natumi Napój owsiany z wapniem 1 l Bio";
        String searchInputID = "search_query_top";
        String productImg = "//*[@id=\"product-list\"]/div[2]/div[1]/div/div/div[1]/a/img";
        String loadingIcon = "pfbx-preloader";
        String addToCartButton = "//*[@id=\"AddToCartBox\"]/form/div[2]/div/p/button/span";

        fluentWait(By.id(searchInputID));
        driver.findElement(By.id(searchInputID)).sendKeys(productName);
        driver.findElement(By.id(searchInputID)).submit();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,300)");

        waitForInvisibility(loadingIcon);
        driver.findElement(By.xpath(productImg)).click();
        fluentWait(By.xpath(addToCartButton));
        driver.findElement(By.xpath(addToCartButton)).click();

    }



}
