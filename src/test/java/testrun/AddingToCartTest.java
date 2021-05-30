package testrun;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingToCartTest {

    String url = "https://bee.pl";
    WebDriver driver;

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
    public void isMainPageAvailable() throws Exception{
       Assertions.assertTrue(contentAvailability(driver));
    }

    @Test
    public void isProductOnTheList() {

        //assertion

    }

    @Test
    public void isProductInCart() {
        //searchPhrase
        //openProductPage
        //addProductToCart
        //goToCart
        //assertion
    }


}
