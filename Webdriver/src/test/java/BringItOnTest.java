import bringItOnAndICanWinPages.NewPastePage;
import bringItOnAndICanWinPages.PasteBinMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BringItOnTest {
    private WebDriver driver;
    private NewPastePage newPastePage;
    private String expectedCode="git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private String expectedName="how to gain dominance among developers";

    @BeforeTest
    public void driverSetUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void pasteDataTest() {
        newPastePage=new PasteBinMainPage(driver)
                .openPage()
                .writeCode(expectedCode)
                .choseSyntaxHighlighting("Bash")
                .choseExpiration("10 Minutes")
                .writeName(expectedName)
                .createNewPaste();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(expectedName,newPastePage.getHeading());
        softAssert.assertEquals("Bash",newPastePage.getSyntaxHighlighting());
        softAssert.assertEquals(expectedCode,newPastePage.getCode());
        softAssert.assertAll();
    }

     @AfterTest
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}

