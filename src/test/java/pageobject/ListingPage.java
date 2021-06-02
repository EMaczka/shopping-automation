package pageobject;

import helpers.SupportFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListingPage {

    private final WebDriver driver;
    private final SupportFunctions helper;

    String productName = "Natumi Napój owsiany z wapniem 1 l Bio";
    String searchInputID = "search_query_top";
    String productImg = "//*[@id=\"product-list\"]/div[2]/div[1]/div/div/div[1]/a/img";
    String loadingIcon = "pfbx-preloader";

    public ListingPage(WebDriver driver) {

        this.driver = driver;
        this.helper = new SupportFunctions(driver);
    }

    public void openProductPage() {

        helper.fluentWait(By.id(searchInputID));
        driver.findElement(By.id(searchInputID)).sendKeys(productName);
        driver.findElement(By.id(searchInputID)).submit();

        helper.scroll300px();
        helper.waitForInvisibility(loadingIcon);
        driver.findElement(By.xpath(productImg)).click();
    }


}
