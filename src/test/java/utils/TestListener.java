package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object testObject = result.getInstance();

        if (testObject instanceof BaseTest) {

            WebDriver driver =
                    ((BaseTest) testObject).getDriver();

            String testName =
                    result.getMethod().getMethodName();

            ScreenshotUtil.captureScreenshot(
                    driver,
                    testName
            );
        }
    }
}