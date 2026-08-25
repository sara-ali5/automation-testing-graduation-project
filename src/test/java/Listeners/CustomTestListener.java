package Listeners;
import Base.BaseTest;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Utilities.DriverManager;

import java.io.ByteArrayInputStream;

public class CustomTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        try {

            if (DriverManager.getDriver() != null) {

                byte[] screenshot =
                        ((TakesScreenshot) DriverManager.getDriver())
                                .getScreenshotAs(OutputType.BYTES);

                Allure.addAttachment(
                        "Failure Screenshot",
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        ".png"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Failed to capture screenshot: "
                            + e.getMessage()
            );
        }
    }
}