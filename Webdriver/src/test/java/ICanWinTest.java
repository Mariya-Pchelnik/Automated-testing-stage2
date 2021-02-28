import bringItOnAndICanWinPages.PasteBinMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ICanWinTest {
    WebDriver driver;
    PasteBinMainPage pasteBinMainPage;

    @BeforeTest
    public void driverSetUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void fillInForm() {
        pasteBinMainPage = new PasteBinMainPage(driver);
        pasteBinMainPage.openPage()
                .writeCode("Hello from WebDriver")
                .choseExpiration("10 Minutes")
                .choseSyntaxHighlighting("Bash")
                .writeName(" helloweb");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
