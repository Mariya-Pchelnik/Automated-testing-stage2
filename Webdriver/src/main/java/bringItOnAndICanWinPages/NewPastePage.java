package bringItOnAndICanWinPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.Waits;

public class NewPastePage extends AbstractPage {
    @FindBy(xpath = "//h1")
    WebElement heading;
    @FindBy(xpath = "//div[@class='left']//a")
    WebElement syntaxHighlighting;
    @FindBy(xpath = "//ol")
    WebElement code;

    protected NewPastePage(WebDriver driver) {
        super(driver);
    }

    public String getHeading() {
        Waits.waitForVisibilityOfTheWebElement(driver, heading);
        return heading.getText();
    }

    public String getSyntaxHighlighting() {
        Waits.waitForVisibilityOfTheWebElement(driver, syntaxHighlighting);
        return syntaxHighlighting.getText();
    }

    public String getCode() {
        Waits.waitForVisibilityOfTheWebElement(driver, code);
        return code.getText();
    }
}
