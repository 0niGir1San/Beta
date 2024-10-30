package com.demoqa.listener;

import com.demoqa.drivers.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    private WebDriver driver;

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Hello OnStart");
        driver = DriverManager.getDriver(); // Инициализация driver при старте
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Hello on Test Start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Hello on Test Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        if (driver != null) {
            System.out.println("Taking screenshot...");
            saveScreenshotPNG();
        } else {
            System.out.println("Driver is null, cannot take screenshot.");
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Hello onFinish");
    }
}
