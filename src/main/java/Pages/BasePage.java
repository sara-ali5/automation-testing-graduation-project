package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.ConfigReader;
import Utilities.DriverManager;
import java.time.Duration;

public class BasePage {

    protected WebDriverWait wait;

    public BasePage() {

        wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(
                        Long.parseLong(
                                ConfigReader.get("explicit.wait")
                        )
                )
        );
    }

    protected WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    protected WebElement waitForClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    protected void click(By locator) {

        waitForClickable(locator).click();
    }

    protected void type(
            By locator,
            String text) {

        WebElement element =
                waitForVisibility(locator);

        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {

        return waitForVisibility(locator).getText();
    }

    protected boolean isDisplayed(By locator) {

        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean urlContains(String value) {

        return wait.until(
                ExpectedConditions.urlContains(value)
        );
    }
    public boolean waitForUrlContains(String urlPart) {

        return wait.until(
                ExpectedConditions.urlContains(urlPart)
        );
    }
}