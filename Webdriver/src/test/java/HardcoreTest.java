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
    private GoogleCloudPricingCalculatorPage calculatorPage;
    private EstimatePage estimatePage;
    private MailPage mailPage;
    private String mailHandle;

    @BeforeTest
    public void setUpDriver() {
        driver = new ChromeDriver();
        calculatorPage = new GoogleCloudHomePage(driver).openPage()
                .searchForTerms("Google Cloud Platform Pricing Calculator")
                .selectResult();
        estimatePage = fillInForm(calculatorPage).addToEstimate();
    }

    @Test
    public void sendCostByMailTest() {
        String expectedResult = estimatePage.getTotalCost();

        openMailPageAndGetEmailAddress();
        sendEstimateByMail();
        Assert.assertEquals(expectedResult, acceptLetterAndGetTotalCost());
    }

    @AfterTest()
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }

    private void openMailPageAndGetEmailAddress() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabList = new ArrayList<>(driver.getWindowHandles());
        String estimateHandle = String.valueOf(tabList.get(0));
        mailHandle = String.valueOf(tabList.get(1));
        driver.switchTo().window(mailHandle);
        mailPage = new MailPage(driver);
        mailPage.openPage().getMailAddress();
        driver.switchTo().window(estimateHandle);
    }

    private void sendEstimateByMail() {
        EmailEstimateFormPage formPage = estimatePage.goInTheFrame()
                .sendEstimateByEmail();
        formPage.inputEmail();
        formPage.sendEmail();
    }

    private String acceptLetterAndGetTotalCost() {
        driver.switchTo().window(mailHandle);
        return mailPage.getTotalCostFromMail();

    }

    private GoogleCloudPricingCalculatorPage fillInForm(
            GoogleCloudPricingCalculatorPage pricingCalculatorPage) {
        return pricingCalculatorPage
                .goInTheFrame().selectComputeEngine().inputInstanceNumber("4")
                .selectOperatingSystem().selectMachineClass()
                .selectSeries().selectMachineType().addGPUs()
                .selectLocalSSD().selectDataCenterLocation().selectCommitedUsage();
    }
}
