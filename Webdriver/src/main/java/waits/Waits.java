package waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private static final Duration WAIT_TIMEOUT_SECONDS=Duration.ofSeconds(20);

    public  static WebElement waitForVisibilityOfTheWebElement(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).
                until(ExpectedConditions.visibilityOf(element));
    }

    public  static WebElement waitForWebElementToBeClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).
                until(ExpectedConditions.elementToBeClickable(element));
    }
}
