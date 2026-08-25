package Tests;
import Base.BaseTest;
import Pages.BasePage;
import Utilities.DriverManager;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.DashboardPage;
import Utilities.JsonDataReader;

@Epic("OrangeHRM Web Application")
@Feature("Authentication")
public class LoginTest extends BaseTest {

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {

        return new Object[][]{

                {
                        JsonDataReader.get(
                                "invalidLogin",
                                "username"
                        ),

                        JsonDataReader.get(
                                "invalidLogin",
                                "password"
                        )
                }
        };
    }

    @Test(description = "Login with valid credentials", groups = {"Regression", "Smoke"})
    @Story("Valid Login")
    @Severity(SeverityLevel.BLOCKER)
    @Description("""
            Verify that a valid Admin user can log in successfully
            and is redirected to the OrangeHRM Dashboard.
            """)
    public void validLoginTest() {

        loginPage.login(
                JsonDataReader.get(
                        "validLogin",
                        "username"
                ),
                JsonDataReader.get(
                        "validLogin",
                        "password"
                )
        );

        Assert.assertTrue(
                loginPage.waitForUrlContains("/dashboard/index"),
                "URL should contain /dashboard/index"
        );

        DashboardPage dashboardPage =
                new DashboardPage();

        Assert.assertTrue(
                dashboardPage.isDashboardDisplayed(),
                "Dashboard header should be displayed"
        );
    }

    @Test(description = "Login with invalid credentials", groups = {"Regression"},dataProvider = "invalidLoginData")
    @Story("Invalid Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
        Verify that an appropriate error message is displayed
        when invalid username and password are entered.
        """)
    public void invalidLoginTest(
            String username,
            String password) {

        loginPage.login(
                username,
                password
        );

        Assert.assertTrue(
                loginPage.isInvalidCredentialsDisplayed(),
                "Invalid credentials message should be displayed"
        );
    }




    @Test(
            description = "Verify validation messages for empty login fields"
    )
    @Description("Verify Required validation messages for username and password")
    @Severity(SeverityLevel.CRITICAL)
    public void emptyFieldsLoginTest() {

        Allure.step("Open OrangeHRM login page");

        Allure.step("Click Login without entering credentials");
        loginPage.clickLogin();

        Allure.step("Verify username Required message");
        Assert.assertTrue(
                loginPage.isUsernameRequiredDisplayed(),
                "Required validation should appear under username"
        );

        Allure.step("Verify password Required message");
        Assert.assertTrue(
                loginPage.isPasswordRequiredDisplayed(),
                "Required validation should appear under password"
        );
    }
}