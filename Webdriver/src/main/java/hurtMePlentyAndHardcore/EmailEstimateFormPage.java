package hurtMePlentyAndHardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.Waits;

public class EmailEstimateFormPage extends AbstractPage {
    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//button[@aria-label=\"Send Email\"]")
    private WebElement buttonSendEmail;

    public EmailEstimateFormPage(WebDriver driver) {
        super(driver);
    }

    public EmailEstimateFormPage inputEmail() {
        Waits.waitForVisibilityOfTheWebElement(driver, inputEmail);
        inputEmail.sendKeys(MailPage.mailAddress);
        return this;
    }

    public MailPage sendEmail() {
        Waits.waitForWebElementToBeClickable(driver, buttonSendEmail);
        buttonSendEmail.click();
        return new MailPage(driver);
    }
}
