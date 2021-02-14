package bringItOnAndICanWinPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.Waits;

public class PasteBinMainPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    @FindBy(id = "postform-text")
    private WebElement newPaste;
    @FindBy(id = "select2-postform-format-container")
    WebElement syntaxHighlighting;
    @FindBy(xpath = "//li[@role='option' and text()='Bash']")
    WebElement syntaxHighlightingBash;
    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement pasteExpiration;
    @FindBy(xpath = "//li[@role='option' and text()='10 Minutes']")
    private WebElement pasteExpiration10Minutes;
    @FindBy(id = "postform-name")
    private WebElement pasteName;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement createNewPasteButton;

    public PasteBinMainPage(WebDriver driver) {
        super(driver);
    }

    public PasteBinMainPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PasteBinMainPage writeCode(String code) {
        Waits.waitForVisibilityOfTheWebElement(driver, newPaste)
                .sendKeys(code);
        return this;
    }

    public PasteBinMainPage choseSyntaxHighlighting() {
        Waits.waitForWebElementToBeClickable(driver, syntaxHighlighting)
                .click();
        Waits.waitForWebElementToBeClickable(driver, syntaxHighlightingBash)
                .click();
        return this;
    }

    public PasteBinMainPage choseExpiration() {
        Waits.waitForWebElementToBeClickable(driver, pasteExpiration)
                .click();
        Waits.waitForWebElementToBeClickable(driver, pasteExpiration10Minutes).
                click();
        return this;
    }

    public PasteBinMainPage writeName(String name) {
        Waits.waitForVisibilityOfTheWebElement(driver, pasteName)
                .sendKeys(name);
        return this;
    }

    public NewPastePage createNewPaste() {
        Waits.waitForWebElementToBeClickable(driver, createNewPasteButton)
                .click();
        return new NewPastePage(driver);
    }
}
