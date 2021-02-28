import hurtMePlentyAndHardcore.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HardcoreTest {
    private WebDriver driver;

    @BeforeTest
    public void setUpDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void sendCostByMailTest() {
        EstimatePage estimatePage = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForTerms("Google Cloud Platform Pricing Calculator")
                .selectResult()
                .goInTheFrame()
                .selectComputeEngine()
                .inputInstanceNumber("4")
                .selectOperatingSystem("free")
                .selectMachineClass("regular")
                .selectSeries("n1")
                .selectMachineType("CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8")
                .addGPUs("1", "NVIDIA_TESLA_V100")
                .selectLocalSSD("2x375 GB")
                .selectDataCenterLocation("europe-west3")
                .selectCommitedUsage("1")
                .addToEstimate();
        String expectedResult = estimatePage.getTotalCost();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabList = new ArrayList<>(driver.getWindowHandles());
        String estimateHandle = String.valueOf(tabList.get(0));
        String mailHandle = String.valueOf(tabList.get(1));

        driver.switchTo().window(mailHandle);
        MailPage mailPage = new MailPage(driver)
                .openPage()
                .setMailAddress();

        driver.switchTo().window(estimateHandle);
        estimatePage
                .goInTheFrame()
                .sendEstimateByEmail()
                .inputEmail()
                .sendEmail();

        driver.switchTo().window(mailHandle);
        String currentResult = mailPage.getTotalCostFromMail();

        Assert.assertEquals(expectedResult, currentResult);
    }

    @AfterTest()
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
