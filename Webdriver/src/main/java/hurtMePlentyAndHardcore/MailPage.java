package hurtMePlentyAndHardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.Waits;

import java.time.Duration;

public class MailPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://10minutemail.com/";
    static String mailAddress;
    @FindBy(id = "mail_address")
    WebElement fieldMailAddress;
    @FindBy(xpath = "//span[text()='Google Cloud Platform Price Estimate']")
    WebElement mailLetter;
    @FindBy(xpath = "//h2[contains(text(), 'Estimated Monthly Cost:')]")
    WebElement totalCost;

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public MailPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public MailPage setMailAddress() {
        Waits.waitForVisibilityOfTheWebElement(driver, fieldMailAddress);
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions
                        .attributeContains(fieldMailAddress, "value", "@"));
        mailAddress = fieldMailAddress.getAttribute("value");
        return this;
    }

    public String getTotalCostFromMail() {
        Waits.waitForWebElementToBeClickable(driver, mailLetter);
        mailLetter.click();
        Waits.waitForVisibilityOfTheWebElement(driver, totalCost);
        return totalCost.getText().replaceAll("[^0-9.]", "");
    }
}
