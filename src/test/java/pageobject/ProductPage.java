package pageobject;

import helpers.SupportFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    private final WebDriver driver;
    private final SupportFunctions helper;

    String addToCartButton = "//*[@id=\"AddToCartBox\"]/form/div[2]/div/p/button/span";
    String productImg = "/html/body/div[2]/div[3]/div/div/section/div[1]/div[1]/div[1]/span[2]/a/img";

    public ProductPage(WebDriver driver) {

        this.driver = driver;
        this.helper = new SupportFunctions(driver);
    }

    public WebElement getProduct() {

        return helper.getProductByXpath(productImg);
    }

   public void addProductToCart() {

        helper.fluentWait(By.xpath(addToCartButton));
        driver.findElement(By.xpath(addToCartButton)).click();
    }
}
