package pageobject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class MainPage {
    String mainPageHeader = "header";
    String mainPageContent = "content";
    String productName = "Natumi Napój owsiany z wapniem 1 l Bio";
    String searchInputID = "search_query_top";


    public boolean contentAvailability(WebDriver driver) {
        WebElement ele = fluentWait(driver, mainPageHeader); { }
    /*
    public searchPhrase() {}
    */
}

    
