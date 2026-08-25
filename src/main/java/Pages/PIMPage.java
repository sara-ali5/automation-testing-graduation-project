package Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PIMPage extends BasePage {

    private final By pimMenu =
            By.xpath("//span[normalize-space()='PIM']");

    private final By employeeListMenu =
            By.xpath("//a[normalize-space()='Employee List']");

    private final By addEmployeeMenu =
            By.xpath("//a[normalize-space()='Add Employee']");

    private final By pimHeader =
            By.xpath("//h6[normalize-space()='PIM']");

    private final By employeeNameField =
            By.xpath(
                    "//label[normalize-space()='Employee Name']" +
                            "/ancestor::div[contains(@class,'oxd-input-group')]//input"
            );

    private final By searchButton =
            By.xpath("//button[normalize-space()='Search']");

    private final By resetButton =
            By.xpath("//button[normalize-space()='Reset']");

    private final By noRecordsFound =
            By.xpath(
                    "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span"
            );

    private final By employeeTable =
            By.cssSelector(".oxd-table");

    private final By addEmployeeHeader =
            By.xpath("//h6[normalize-space()='Add Employee']");

    private final By firstName =
            By.name("firstName");

    private final By middleName =
            By.name("middleName");

    private final By lastName =
            By.name("lastName");

    private final By saveButton =
            By.xpath("//button[@type='submit']");

    private final By requiredMessage =
            By.xpath(
                    "//span[normalize-space()='Required']"
            );

    private final By personalDetailsHeader =
            By.xpath(
                    "//h6[normalize-space()='Personal Details']"
            );
    @Step("Open PIM module")
    public void openPIM() {

        click(pimMenu);
    }

    @Step("Open Employee List")
    public void openEmployeeList() {

        click(employeeListMenu);
    }


    @Step("Open Add Employee page")
    public void openAddEmployee() {

        click(addEmployeeMenu);
    }


    @Step("Search for employee: {employeeName}")
    public void searchEmployee(String employeeName) {

        type(employeeNameField, employeeName);

        click(searchButton);
    }

    public boolean isEmployeeTableDisplayed() {

        return isDisplayed(employeeTable);
    }

    @Step("Verify employee '{employeeName}' appears in results")
    public boolean isEmployeeDisplayed(
            String employeeName) {

        By employee =
                By.xpath(
                        "//div[contains(@class,'oxd-table-body')]//div[" +
                                "contains(normalize-space(),'" +
                                employeeName +
                                "')]"
                );

        return isDisplayed(employee);
    }

    @Step("Verify No Records Found message is displayed")
    public boolean isNoRecordsFoundDisplayed() {

        return isDisplayed(noRecordsFound);
    }

    public boolean isAddEmployeePageDisplayed() {

        return isDisplayed(addEmployeeHeader);
    }

    public boolean isFirstNameDisplayed() {

        return isDisplayed(firstName);
    }

    public boolean isLastNameDisplayed() {

        return isDisplayed(lastName);
    }

    public void enterFirstName(String value) {

        type(firstName, value);
    }

    public void enterMiddleName(String value) {

        type(middleName, value);
    }

    public void enterLastName(String value) {

        type(lastName, value);
    }

    public void clickSave() {

        click(saveButton);
    }

    public boolean isRequiredMessageDisplayed() {

        return isDisplayed(requiredMessage);
    }

    public boolean isPersonalDetailsDisplayed() {

        return isDisplayed(personalDetailsHeader);
    }

    public void addEmployee(
            String firstNameValue,
            String lastNameValue) {

        enterFirstName(firstNameValue);
        enterLastName(lastNameValue);
        clickSave();
    }
}