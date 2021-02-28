package hurtMePlentyAndHardcore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.Waits;

import java.util.List;

public class SearchResultsPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='gs-title']/a[@class='gs-title' and @href]")
    private List<WebElement> requiredResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage selectResult() {
        Waits.waitForVisibilityOfAllWebElements(driver, requiredResults);
        requiredResults.get(0).click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}

