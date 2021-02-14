package hurtMePlentyAndHardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.Waits;

public class EstimatePage extends AbstractPage {
    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(), 'VM class')]")
    WebElement vmClass;
    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(), 'Instance type')]")
    WebElement instanceType;
    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(), 'Region')]")
    WebElement region;
    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(), 'Total available local SSD space')]")
    WebElement localSSD;
    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(), 'Commitment term:')]")
    WebElement commitmentTerm;
    @FindBy(xpath = "//b[contains(text(), 'Total Estimated Cost')]")
    WebElement totalCost;
    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailEstimate;

    public EstimatePage(WebDriver driver) {
        super(driver);
    }

    public EstimatePage goInTheFrame() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        return this;
    }
    public String getVmClass() {
        return Waits.waitForVisibilityOfTheWebElement(driver, vmClass)
                .getText();
    }

    public String getInstanceType() {
        return Waits.waitForVisibilityOfTheWebElement(driver, instanceType)
                .getText();
    }

    public String getRegion() {
        return Waits.waitForVisibilityOfTheWebElement(driver, region)
                .getText();
    }

    public String getLocalSSD() {
        return Waits.waitForVisibilityOfTheWebElement(driver, localSSD)
                .getText();
    }

    public String getCommitmentTerm() {
        return Waits.waitForVisibilityOfTheWebElement(driver, commitmentTerm)
                .getText();
    }

    public String getTotalCost() {
        return Waits.waitForVisibilityOfTheWebElement(driver, totalCost)
                .getText() .replace("per 1 month","")
                .replaceAll("[^0-9.]","");
    }

    public EmailEstimateFormPage sendEstimateByEmail() {
        Waits.waitForWebElementToBeClickable(driver, emailEstimate).click();
        return new EmailEstimateFormPage(driver);
    }
}
