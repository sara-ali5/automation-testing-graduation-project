package Tests;
import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.FooterPage;
import Utilities.DriverManager;

@Epic("OrangeHRM Web Application")
@Feature("UI and Branding")
@Owner("Sara")
public class FooterTest extends BaseTest {

    @Test(
            description = "Verify OrangeHRM footer branding link",
            groups = {"Regression", "UI"}
    )
    @Story("OrangeHRM Footer Branding")
    @Severity(SeverityLevel.MINOR)
    @Description("""
            Verify that the OrangeHRM footer contains the
            OrangeHRM, Inc branding link and that clicking
            the link opens an OrangeHRM website in a new tab.
            """)
    public void verifyFooterBrandingTest() {

        loginAsAdmin();

        FooterPage footerPage =
                new FooterPage();

        footerPage.scrollToFooter();

        String footerText =
                footerPage.getFooterText();

        Assert.assertTrue(
                footerText.contains("OrangeHRM, Inc"),
                "Footer should contain OrangeHRM, Inc"
        );

        String originalWindow =
                DriverManager.getDriver()
                        .getWindowHandle();

        footerPage.clickOrangeHRMLink();

        footerPage.switchToNewTab();

        Assert.assertTrue(
                DriverManager.getDriver()
                        .getCurrentUrl()
                        .contains("orangehrm.com"),
                "New tab URL should contain orangehrm.com"
        );

        DriverManager.getDriver()
                .switchTo()
                .window(originalWindow);
    }
}
