package Pages;

import Utilities.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class FooterPage extends BasePage {

    private final By footerText =
            By.xpath(
                    "//*[contains(normalize-space(), 'OrangeHRM, Inc')]"
            );

    private final By orangeHRMLink =
            By.xpath(
                    "//a[contains(normalize-space(), 'OrangeHRM, Inc')]"
            );


    @Step("Scroll to OrangeHRM footer")
    public void scrollToFooter() {

        JavascriptExecutor js =
                (JavascriptExecutor) DriverManager.getDriver();

        js.executeScript(
                "window.scrollTo(0, document.body.scrollHeight);"
        );
    }


    @Step("Verify footer contains OrangeHRM branding")
    public String getFooterText() {

        return getText(footerText);
    }


    @Step("Click OrangeHRM, Inc footer link")
    public void clickOrangeHRMLink() {

        click(orangeHRMLink);
    }


    @Step("Switch to newly opened OrangeHRM tab")
    public void switchToNewTab() {

        String currentWindow =
                DriverManager.getDriver()
                        .getWindowHandle();

        wait.until(
                driver ->
                        driver.getWindowHandles().size() > 1
        );

        for (String window :
                DriverManager.getDriver()
                        .getWindowHandles()) {

            if (!window.equals(currentWindow)) {

                DriverManager.getDriver()
                        .switchTo()
                        .window(window);

                break;
            }
        }
    }
}