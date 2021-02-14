package hurtMePlentyAndHardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.Waits;

public class SearchResultsPage extends AbstractPage{
    @FindBy(xpath = "//div[@class='gs-title']/a[@data-ctorig='https://cloud.google.com/products/calculator']")
    private WebElement requiredResult;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public  GoogleCloudPricingCalculatorPage selectResult(){
        Waits.waitForWebElementToBeClickable(driver,requiredResult)
                .click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}
