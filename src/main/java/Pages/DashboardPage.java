package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    private final By dashboardHeader =
            By.xpath("//h6[normalize-space()='Dashboard']");


    @Step("Verify Dashboard URL contains /dashboard/index")
    public boolean isDashboardDisplayed() {

        return isDisplayed(dashboardHeader);
    }

    @Step("Verify Dashboard header is displayed")
    public String getDashboardTitle() {

        return getText(dashboardHeader);
    }
}