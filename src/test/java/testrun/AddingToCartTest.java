package testrun;

import helpers.SupportFunctions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.CartPage;
import pageobject.ListingPage;
import pageobject.MainPage;
import pageobject.ProductPage;

public class AddingToCartTest {

    String url = "https://bee.pl";
    WebDriver driver;
    SupportFunctions helper;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        helper = new SupportFunctions(driver);
    }

    @AfterEach
    public void driverQuit() {
        driver.quit();
    }

    @Test
    public void isMainPageAvailable() throws Exception {

        WebElement page = new MainPage(driver).startPage();
        Assertions.assertTrue(page.isEnabled());

    }

    @Test
    public void isProductFirstOnTheList() throws Exception {

        ListingPage listingpage = new ListingPage(driver);
        listingpage.openProductPage();
        helper.scroll300px();
        ProductPage productPage = new ProductPage(driver);
        WebElement ele = productPage.getProduct();
        String title = ele.getAttribute("title");
        Assertions.assertEquals("Natumi Napój owsiany z wapniem 1 l Bio", title);
    }

    @Test
    public void isCorrectProductInCart() throws Exception {

        ListingPage listingpage = new ListingPage(driver);
        listingpage.openProductPage();
        helper.scroll300px();
        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart();
        CartPage cartPage = new CartPage(driver);
        Assertions.assertTrue(cartPage.isCorrectItemInCart());
    }

}
