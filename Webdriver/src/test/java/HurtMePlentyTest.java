import hurtMePlentyAndHardcore.EstimatePage;
import hurtMePlentyAndHardcore.GoogleCloudHomePage;
import hurtMePlentyAndHardcore.GoogleCloudPricingCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HurtMePlentyTest {
    private WebDriver driver;
    private EstimatePage estimatePage;
    private GoogleCloudPricingCalculatorPage calculatorPage;

    @BeforeTest
    public void setUpDriver() {
        driver = new ChromeDriver();
        calculatorPage = new GoogleCloudHomePage(driver).openPage()
                .searchForTerms("Google Cloud Platform Pricing Calculator")
                .selectResult();
        estimatePage=fillInForm(calculatorPage).addToEstimate();
    }

    @Test
    public void testVMSelection() {
        Assert.assertEquals("VM class: regular"
                , estimatePage.getVmClass());
    }

    @Test
    public void testInstanceType() {
        Assert.assertEquals("Instance type: n1-standard-8"
                , estimatePage.getInstanceType());
    }

    @Test
    public void testRegion() {
        Assert.assertEquals("Region: Frankfurt"
                , estimatePage.getRegion());
    }

    @Test
    public void testLocalSSD() {
        Assert.assertEquals("Total available local SSD space 2x375 GiB", estimatePage.getLocalSSD());
    }

    @Test
    public void testCommitmentTerm() {
        Assert.assertEquals("Commitment term: 1 Year", estimatePage.getCommitmentTerm());
    }

    @Test
    public void testTotalCost() {
        Assert.assertEquals("Total Estimated Cost: USD 1,082.77 per 1 month", estimatePage.getTotalCost());
    }


    @AfterTest()
    public void shutDownDriver() {
        driver.quit();
        driver=null;
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
