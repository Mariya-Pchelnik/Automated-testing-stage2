package com.epam.learn.tests;

import com.epam.learn.model.ComputeEngine;
import com.epam.learn.pages.EstimatePage;
import com.epam.learn.pages.GoogleCloudHomePage;
import com.epam.learn.pages.MailPage;
import com.epam.learn.service.ComputeEngineCreator;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GoogleCloudPricingCalculatorTest extends CommonConditions {

    @Test
    public void sendCostByMailTest() {
        ComputeEngine computeEngine= ComputeEngineCreator.withGPU();
        EstimatePage estimatePage = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForTerms("Google Cloud Platform Pricing Calculator")
                .selectResult()
                .goInTheFrame()
                .selectComputeEngine()
                .inputInstanceNumber(computeEngine.getInstanceNumber())
                .selectOperatingSystem(computeEngine.getSystem())
                .selectMachineClass(computeEngine.getMachineClass())
                .selectSeries(computeEngine.getSeries())
                .selectMachineType(computeEngine.getMachineType())
                .addGPUs(computeEngine.getNumberOfGPUs(), computeEngine.getTypeOfGPU())
                .selectLocalSSD(computeEngine.getLocalSSD())
                .selectDataCenterLocation(computeEngine.getDatacenterLocation())
                .selectCommitedUsage(computeEngine.getCommitedUsage())
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
}
