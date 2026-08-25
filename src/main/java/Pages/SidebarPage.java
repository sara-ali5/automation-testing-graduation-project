package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SidebarPage extends BasePage {

    private final String[] menuItems = {
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

    @Step("Verify sidebar contains '{menuItem}'")
    public boolean isMenuItemDisplayed(
            String menuItem) {

        By locator =
                By.xpath(
                        "//span[normalize-space()='" +
                                menuItem +
                                "']"
                );

        return isDisplayed(locator);
    }

    public boolean areAllMenuItemsDisplayed() {

        for (String menuItem : menuItems) {

            if (!isMenuItemDisplayed(menuItem)) {
                return false;
            }
        }

        return true;
    }
}