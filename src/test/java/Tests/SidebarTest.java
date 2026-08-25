package Tests;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.SidebarPage;

@Epic("OrangeHRM Web Application")
@Feature("Navigation")
@Owner("Sara")
public class SidebarTest extends BaseTest {

    @Test(
            description = "Verify sidebar menu items",
            groups = {"Regression", "UI"}
    )
    @Story("Sidebar Menu")
    @Severity(SeverityLevel.NORMAL)
    @Description("""
            Verify that the OrangeHRM sidebar contains all
            required navigation menu items for an authenticated
            administrator.
            """)
    public void verifySidebarMenuTest() {

        loginAsAdmin();

        SidebarPage sidebarPage =
                new SidebarPage();

        String[] expectedItems = {
                "Admin",
                "PIM",
                "Leave",
                "Time",
                "Recruitment",
                "My Info",
                "Performance",
                "Dashboard",
                "Directory"
        };

        for (String item : expectedItems) {

            Assert.assertTrue(
                    sidebarPage.isMenuItemDisplayed(item),
                    item + " should be displayed in sidebar"
            );
        }
    }
}
