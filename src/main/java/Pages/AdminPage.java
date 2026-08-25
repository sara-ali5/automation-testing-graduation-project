package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AdminPage extends BasePage {

    private final By adminMenu =
            By.xpath("//span[normalize-space()='Admin']");

    private final By userManagement =
            By.xpath(
                    "//span[normalize-space()='User Management']"
            );

    private final By usersSubMenu =
            By.xpath(
                    "//a[normalize-space()='Users']"
            );

    private final By addButton =
            By.xpath("//button[normalize-space()='Add']");

    private final By userRole =
            By.xpath(
                    "//label[normalize-space()='User Role']"
            );

    private final By employeeName =
            By.xpath(
                    "//label[normalize-space()='Employee Name']"
            );

    private final By username =
            By.xpath(
                    "//label[normalize-space()='Username']"
            );

    private final By password =
            By.xpath(
                    "//label[normalize-space()='Password']"
            );

    @Step("Open Admin module")
    public void openAdmin() {

        click(adminMenu);
    }

    @Step("Open Users page")
    public void openUsers() {

        click(userManagement);

        waitForVisibility(usersSubMenu);

        click(usersSubMenu);
    }


    @Step("Click Add User button")
    public void clickAdd() {

        click(addButton);
    }

    @Step("Verify User Role field is displayed")
    public boolean isUserRoleDisplayed() {

        return isDisplayed(userRole);
    }

    @Step("Verify Employee Name field is displayed")
    public boolean isEmployeeNameDisplayed() {

        return isDisplayed(employeeName);
    }


    @Step("Verify Username field is displayed")
    public boolean isUsernameDisplayed() {

        return isDisplayed(username);
    }

    @Step("Verify Password field is displayed")
    public boolean isPasswordDisplayed() {

        return isDisplayed(password);
    }
}