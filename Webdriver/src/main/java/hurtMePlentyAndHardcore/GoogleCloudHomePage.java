package hurtMePlentyAndHardcore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.Waits;

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

    public SearchResultsPage searchForTerms(String terms){
        Waits.waitForWebElementToBeClickable(driver, searchInput)
                .click();
        Waits.waitForVisibilityOfTheWebElement(driver, searchInput)
                .sendKeys(terms);
        searchInput.sendKeys(Keys.ENTER);
        return new  SearchResultsPage(driver);
    }
}
