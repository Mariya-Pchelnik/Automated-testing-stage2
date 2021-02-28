package com.epam.learn.pages;

import com.epam.learn.waits.Waits;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL ="https://cloud.google.com/";

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultsPage searchForTerms(String request){
        Waits.waitForWebElementToBeClickable(driver, searchInput)
                .click();
        Waits.waitForVisibilityOfTheWebElement(driver, searchInput)
                .sendKeys(request);
        searchInput.sendKeys(Keys.ENTER);
        logger.info("Searching for["+ request +"] has started");
        return new  SearchResultsPage(driver);
    }
}
