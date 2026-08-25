package Tests;
import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.AdminPage;

@Epic("OrangeHRM Web Application")
@Feature("User Management")
@Owner("Sara")
public class AdminTest extends BaseTest {

    @Test(
            description = "Verify Admin Add User page",
            groups = {"Regression"}
    )
    @Story("Add User Page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            Verify that an administrator can navigate to
            Admin > User Management > Users, click Add,
            and view all required Add User form fields.
            """)
    public void verifyAddUserPageTest() {

        loginAsAdmin();

        AdminPage adminPage =
                new AdminPage();

        adminPage.openAdmin();

        adminPage.openUsers();

        adminPage.clickAdd();

        Assert.assertTrue(
                adminPage.isUserRoleDisplayed(),
                "User Role field should be displayed"
        );

        Assert.assertTrue(
                adminPage.isEmployeeNameDisplayed(),
                "Employee Name field should be displayed"
        );

        Assert.assertTrue(
                adminPage.isUsernameDisplayed(),
                "Username field should be displayed"
        );

        Assert.assertTrue(
                adminPage.isPasswordDisplayed(),
                "Password field should be displayed"
        );
    }
}