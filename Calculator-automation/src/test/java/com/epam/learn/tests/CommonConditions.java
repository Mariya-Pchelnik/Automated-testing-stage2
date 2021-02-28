package com.epam.learn.tests;

import com.epam.learn.driver.DriverSingleton;
import com.epam.learn.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeTest()
    public void setUp() {
        System.setProperty("browser", "chrome");
        System.setProperty("environment","dev");
        driver = DriverSingleton.getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void stopBrowser(){
        DriverSingleton.closeDriver();
    }
}