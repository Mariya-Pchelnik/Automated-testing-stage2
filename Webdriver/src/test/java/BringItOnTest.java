import bringItOnAndICanWinPages.NewPastePage;
import bringItOnAndICanWinPages.PasteBinMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
        newPastePage=fillInForm().createNewPaste();
    }

    @Test
    public void inputTitleTest() {
        String currentTitle = newPastePage.getHeading();
        Assert.assertEquals(currentTitle,expectedName );
    }

    @Test
    public void chooseSyntaxHighlightingTest() {
        String currentHighLighting = newPastePage.getSyntaxHighlighting();
        Assert.assertEquals("Bash", currentHighLighting);
    }

    @Test
    public void pasteCodeTest() {
        String currentCode = newPastePage.getCode();
        Assert.assertEquals(expectedCode, currentCode);
    }

     @AfterTest
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }

    private PasteBinMainPage fillInForm() {
        return new PasteBinMainPage(driver)
                .openPage()
                .writeCode(expectedCode)
                .choseSyntaxHighlighting()
                .choseExpiration()
                .writeName(expectedName);
    }

}

