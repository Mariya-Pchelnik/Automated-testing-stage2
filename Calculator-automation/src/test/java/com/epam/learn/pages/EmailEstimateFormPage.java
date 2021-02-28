package com.epam.learn.pages;

import com.epam.learn.waits.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        logger.info("Email input was performed");
        return this;
    }

    public MailPage sendEmail() {
        Waits.waitForWebElementToBeClickable(driver, buttonSendEmail);
        buttonSendEmail.click();
        logger.info("Email was sent");
        return new MailPage(driver);
    }
}
