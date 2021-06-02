package pageobject;

import helpers.SupportFunctions;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;
    private final SupportFunctions helper;

    String productTitle = "/html/body/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div[2]/h5/a";

    public CartPage(WebDriver driver) {

        this.driver = driver;
        this.helper = new SupportFunctions(driver);
    }

    public boolean isCorrectItemInCart() {

        return helper.getProductByXpath(productTitle).isEnabled();
    }
}
