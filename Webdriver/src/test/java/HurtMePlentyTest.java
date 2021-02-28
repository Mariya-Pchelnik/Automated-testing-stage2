import hurtMePlentyAndHardcore.EstimatePage;
import hurtMePlentyAndHardcore.GoogleCloudHomePage;
import hurtMePlentyAndHardcore.GoogleCloudPricingCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HurtMePlentyTest {
    private WebDriver driver;
    private EstimatePage estimatePage;
    private GoogleCloudPricingCalculatorPage calculatorPage;

    @BeforeTest
    public void setUpDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void testDataSelection() {
        estimatePage = new GoogleCloudHomePage(driver)
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
                .addGPUs("1","NVIDIA_TESLA_V100")
                .selectLocalSSD("2x375 GB")
                .selectDataCenterLocation("europe-west3")
                .selectCommitedUsage("1")
                .addToEstimate();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("VM class: regular", estimatePage.getVmClass());
        softAssert.assertEquals("Instance type: n1-standard-8"
                , estimatePage.getInstanceType());
        softAssert.assertEquals("Region: Frankfurt"
                , estimatePage.getRegion());
        softAssert.assertEquals("Total available local SSD space 2x375 GiB"
                , estimatePage.getLocalSSD());
        softAssert.assertEquals("Commitment term: 1 Year",
                estimatePage.getCommitmentTerm());
        softAssert.assertEquals("1082.77"
                , estimatePage.getTotalCost());
        softAssert.assertAll();
    }

    @AfterTest()
    public void shutDownDriver() {
        driver.quit();
        driver = null;
    }
}
