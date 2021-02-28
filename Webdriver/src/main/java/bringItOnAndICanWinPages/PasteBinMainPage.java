package bringItOnAndICanWinPages;

import org.openqa.selenium.By;
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
    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement pasteExpiration;
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
        Waits.waitForVisibilityOfTheWebElement(driver, newPaste);
        newPaste.sendKeys(code);
        return this;
    }

    public PasteBinMainPage choseSyntaxHighlighting(String highlightingType) {
        By xpath = By.xpath("//li[@role='option' and text()='"
                + highlightingType + "']");

        Waits.waitForWebElementToBeClickable(driver, syntaxHighlighting);
        syntaxHighlighting.click();
        Waits.waitForWebElementToBeClickable(driver, xpath)
                .click();
        return this;
    }

    public PasteBinMainPage choseExpiration(String expirationType) {
        By xpath = By.xpath("//li[@role='option' and text()='"
                + expirationType + "']");

        Waits.waitForWebElementToBeClickable(driver, pasteExpiration);
        pasteExpiration.click();
        Waits.waitForWebElementToBeClickable(driver, xpath)
                .click();
        return this;
    }

    public PasteBinMainPage writeName(String name) {
        Waits.waitForVisibilityOfTheWebElement(driver, pasteName);
        pasteName.sendKeys(name);
        return this;
    }

    public NewPastePage createNewPaste() {
        Waits.waitForWebElementToBeClickable(driver, createNewPasteButton);
        createNewPasteButton.click();
        return new NewPastePage(driver);
    }
}
