package com.epam.learn.pages;

import com.epam.learn.waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {
    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngine;
    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstances;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement software;
    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement machineClass;
    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement series;
    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineType;
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']/div[@class='md-container md-ink-ripple']")
    private WebElement addGPUs;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUs;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement typeOfGPU;
    @FindBy(xpath = "//div[@class='ng-scope layout-row']//md-select[@placeholder='Local SSD']")
    private WebElement localSSD;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocation;
    @FindBy(xpath = "//md-select[@ng-change='listingCtrl.onCudChange();']")
    private WebElement commitedUsage;
    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimate;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage goInTheFrame() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectComputeEngine() {
        Waits.waitForWebElementToBeClickable(driver, computeEngine);
        computeEngine.click();
        logger.info("Compute engine was selected");
        return this;
    }

    public GoogleCloudPricingCalculatorPage inputInstanceNumber(String number) {
        Waits.waitForVisibilityOfTheWebElement(driver, numberOfInstances);
        numberOfInstances.sendKeys(number);
        logger.info("Instance number [" + number + "] was set");
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectOperatingSystem(String systemType) {
        By xpath = By.xpath("//md-option[@value='" + systemType + "']");

        Waits.waitForWebElementToBeClickable(driver, software);
        software.click();
        Waits.waitForWebElementToBeClickable(driver, xpath)
                .click();
        logger.info("Operating system [" + systemType + "] was selected");
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineClass(String machineClassType) {
        By xpath = By.xpath("//md-select-menu[@style] /descendant::md-option[@value='"
                + machineClassType + "']");

        Waits.waitForWebElementToBeClickable(driver, machineClass);
        machineClass.click();
        Waits.waitForWebElementToBeClickable(driver, xpath)
                .click();
        logger.info(" Machine class type [" + machineClassType + "] was selected");
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectSeries(String seriesType) {
        By xpath = By.xpath("//md-option[@value='" + seriesType + "']");

        Waits.waitForWebElementToBeClickable(driver, series);
        series.click();
        Waits.waitForWebElementToBeClickable(driver, xpath)
                .click();
        logger.info(" Series type [" + seriesType + "] was selected");
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineType(String selectedMachineType) {
        By xpath = By.xpath("//md-option[@value='"
                + selectedMachineType + "']");

        Waits.waitForWebElementToBeClickable(driver, machineType);
        machineType.click();
        Waits.waitForWebElementToBeClickable(driver, xpath)
                .click();
        logger.info(" Machine type [" + selectedMachineType + "] was selected");
        return this;
    }

    public GoogleCloudPricingCalculatorPage addGPUs(String selectedNumberOfGPUs,
                                                    String selectedTypeOfGPU) {
        By GPUsNumberxpath = By.xpath("//md-select-menu[@style]//md-option[@value='"
                + selectedNumberOfGPUs + "']");
        By GPUsTypeXpath = By.xpath("//md-option[@value='" + selectedTypeOfGPU + "']");

        Waits.waitForWebElementToBeClickable(driver, addGPUs);
        addGPUs.click();
        Waits.waitForWebElementToBeClickable(driver, numberOfGPUs);
        numberOfGPUs.click();
        Waits.waitForWebElementToBeClickable(driver, GPUsNumberxpath)
                .click();
        Waits.waitForWebElementToBeClickable(driver, typeOfGPU);
        typeOfGPU.click();
        Waits.waitForWebElementToBeClickable(driver, GPUsTypeXpath)
                .click();
        logger.info("GPU was added");
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectLocalSSD(String selectedLocalSSD) {
        By xpath = By.xpath("//div[normalize-space()='" + selectedLocalSSD
                + "']/parent::md-option");

        Waits.waitForWebElementToBeClickable(driver, localSSD);
        localSSD.click();
        Waits.waitForWebElementToBeClickable(driver, xpath)
                .click();
        logger.info(" Local SSD [" + selectedLocalSSD + "] was selected");
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectDataCenterLocation(
            String selectedDatacenterLocation) {
        By xpath = By.xpath("//md-select-menu[@class='md-overflow']" +
                "//md-option[@value='" + selectedDatacenterLocation + "']");

        Waits.waitForWebElementToBeClickable(driver, datacenterLocation);
        datacenterLocation.click();
        Waits.waitForWebElementToBeClickable(driver, xpath)
                .click();
        logger.info("Data center location [" + datacenterLocation + "] was selected");
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectCommitedUsage(
            String selectedCommitedUsage) {
        By xpath = By.xpath("//div[@class='md-select-menu-container md-active md-clickable']" +
                "//md-option[@ng-value='" + selectedCommitedUsage + "']");

        Waits.waitForWebElementToBeClickable(driver, commitedUsage);
        commitedUsage.click();
        Waits.waitForWebElementToBeClickable(driver, xpath)
                .click();
        logger.info("Commited usage [" + selectedCommitedUsage + "] was selected");
        return this;
    }

    public EstimatePage addToEstimate() {
        Waits.waitForWebElementToBeClickable(driver, addToEstimate);
        addToEstimate.click();
        logger.info("Compute engine was added to estimate");
        return new EstimatePage(driver);
    }
}
