package Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Pages.LoginPage;
import Utilities.ConfigReader;
import Utilities.DriverManager;

public class BaseTest {

    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {

        DriverManager.initializeDriver();

        DriverManager.getDriver().get(
                ConfigReader.get("base.url")+ "auth/login"
        );

        loginPage = new LoginPage();
    }

    @AfterMethod
    public void tearDown() {

        DriverManager.quitDriver();
    }

    protected void loginAsAdmin() {

        loginPage.login(
                "Admin",
                "admin123"
        );
    }
}