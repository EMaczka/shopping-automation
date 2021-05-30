package helpers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class SupportFunctions {

    public WebElement fluentWait(WebDriver driver, String id) {

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(10, TimeUnit.SECONDS)
            .pollingEvery(5, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
            return driver.findElement(By.id(id));
            }
        });

        return foo;
    };

    /*
    waitForVisibilityOfElementByName{}
    waitForVisibilityOfElementByXpath{}
     */

        
}





