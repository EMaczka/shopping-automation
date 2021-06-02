package pageobject;

import helpers.SupportFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver driver;
    private final SupportFunctions helper;

    String mainPageHeader = "header";

    public MainPage(WebDriver driver) {

        this.driver = driver;
        this.helper = new SupportFunctions(driver);
    }

    public WebElement startPage() {

        WebElement ele = helper.fluentWait(By.id(mainPageHeader));
        return ele;
    }


}



    
