package com.lila.selenium.seleniumtests;

import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumTest {
    private IOSDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("iOS");
        options.setPlatformVersion("17.2");
        options.setDeviceName("iPhone 15 Pro");
        options.setAutomationName("XCUITest");
        options.setApp("/Users/chiachenwu/Library/Developer/Xcode/DerivedData/newAdoption-dflnwvscotsmyrgbrzlnuvppnoxi/Build/Products/Debug-iphonesimulator/newAdoption.app");
        options.setUdid("11C8797B-22BE-4B1F-8D7C-D14F15CA5216");

        // 設定 autoAcceptAlerts 自動處理彈窗
        options.setCapability("autoAcceptAlerts", true);

        URL appiumServerURL = new URL("http://127.0.0.1:4723/");
        driver = new IOSDriver(appiumServerURL, options);
    }

    @Test
    public void testAppLaunch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 等待 noAddLineButton 並點擊
        WebElement noAddLineButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("noAddLineButton")));
        System.out.println("Clicking noAddLineButton...");
        noAddLineButton.click();

        // 等待 colorButton 出現
        WebElement colorButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("colorButton")));
        System.out.println("colorButton found: " + colorButton.isDisplayed());

        // 等待 colorButton 可點擊後點擊
        WebElement clickableColorButton = wait.until(ExpectedConditions.elementToBeClickable(colorButton));
        System.out.println("Clicking colorButton...");
        clickableColorButton.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

