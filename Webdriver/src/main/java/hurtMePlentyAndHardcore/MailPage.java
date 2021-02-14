package hurtMePlentyAndHardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.Waits;

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

    public String getMailAddress() {
        do {
            mailAddress = Waits.waitForVisibilityOfTheWebElement(driver, fieldMailAddress)
                    .getAttribute("value");
        } while (!(mailAddress.contains("@")));
        return mailAddress;
    }

    public String getTotalCostFromMail() {
        Waits.waitForWebElementToBeClickable(driver, mailLetter)
                .click();
        return Waits.waitForVisibilityOfTheWebElement(driver, totalCost)
                .getText().replaceAll("[^0-9.]", "");
    }
}
