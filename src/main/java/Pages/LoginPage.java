package Pages;
import Utilities.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By username =
            By.name("username");

    private final By password =
            By.name("password");

    private final By loginButton =
            By.cssSelector("button[type='submit']");

    private final By errorMessage =
            By.cssSelector(".oxd-alert-content-text");

    private final By requiredMessages =
            By.xpath(
                    "//span[contains(@class,'oxd-input-field-error-message') " +
                            "and normalize-space()='Required']"
            );

    private final By usernameRequired =
            By.xpath("//input[@name='username']/ancestor::div[contains(@class,'oxd-input-group')]//span[normalize-space()='Required']");

    private final By passwordRequired =
            By.xpath("//input[@name='password']/ancestor::div[contains(@class,'oxd-input-group')]//span[normalize-space()='Required']");


    @Step("Enter username: {username}")
    public void enterUsername(String usernameValue) {

        type(username, usernameValue);
    }


    @Step("Enter password")
    public void enterPassword(String passwordValue) {

        type(password, passwordValue);
    }


    @Step("Click Login button")
    public void clickLogin() {

        click(loginButton);
    }


    @Step("Login with username: {username}")
    public void login(
            String usernameValue,
            String passwordValue) {

        enterUsername(usernameValue);
        enterPassword(passwordValue);
        clickLogin();
    }


    @Step("Verify Invalid credentials error message")
    public boolean isInvalidCredentialsDisplayed() {

        return waitForVisibility(errorMessage)
                .getText()
                .contains("Invalid credentials");
    }

    public int getRequiredMessagesCount() {

        return DriverManager.getDriver()
                .findElements(requiredMessages)
                .size();
    }

    @Step("Verify username Required validation is displayed")
    public boolean isUsernameRequiredDisplayed() {
        return !DriverManager.getDriver()
                .findElements(usernameRequired)
                .isEmpty();
    }

    @Step("Verify password Required validation is displayed")
    public boolean isPasswordRequiredDisplayed() {
        return !DriverManager.getDriver()
                .findElements(passwordRequired)
                .isEmpty();
    }
}