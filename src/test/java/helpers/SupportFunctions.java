package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class SupportFunctions {

    private final WebDriver driver;

    public SupportFunctions(WebDriver driver) {

        this.driver = driver;
    }

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

    public void scroll300px() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,300)");
    }

    public WebElement getProductByXpath(String xpath) {

        scroll300px();
        fluentWait(By.xpath(xpath));

        WebElement ele = driver.findElement(By.xpath(xpath));

        return ele;
    }
}
