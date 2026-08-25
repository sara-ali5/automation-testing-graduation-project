package Tests;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.PIMPage;
import Utilities.JsonDataReader;
import Utilities.DriverManager;


@Epic("OrangeHRM Web Application")
@Feature("Employee Management")
@Owner("Sara")
public class PIMTest extends BaseTest {

    private PIMPage pimPage;

    private void navigateToPIM() {

        pimPage = new PIMPage();

        pimPage.openPIM();

        Assert.assertTrue(
                DriverManager.getDriver()
                        .getCurrentUrl()
                        .contains("/pim/"),
                "PIM page should be opened"
        );
    }

    @Test(
            description = "Search for an existing employee",
            groups = {"Regression"}
    )
    @Story("Search Existing Employee")
    @Severity(SeverityLevel.NORMAL)
    @Description("""
            Verify that an existing employee can be searched
            successfully from the PIM Employee List.
            """)
    public void searchExistingEmployeeTest() {

        loginAsAdmin();

        navigateToPIM();

        pimPage.openEmployeeList();

        String employeeName =
                JsonDataReader.get(
                        "searchEmployee",
                        "employeeName"
                );

        pimPage.searchEmployee(employeeName);

        Assert.assertTrue(
                pimPage.isEmployeeTableDisplayed(),
                "Employee results table should be displayed"
        );

        Assert.assertTrue(
                pimPage.isEmployeeDisplayed(employeeName),
                "Search results should contain the searched employee"
        );
    }

    @Test(
            description = "Search for a non-existing employee",
            groups = {"Regression"}
    )
    @Story("Search Non-existing Employee")
    @Severity(SeverityLevel.NORMAL)
    @Description("""
            Verify that searching for an employee that does not
            exist displays the No Records Found message.
            """)
    public void searchNonExistingEmployeeTest() {

        loginAsAdmin();

        navigateToPIM();

        pimPage.openEmployeeList();

        String employeeName =
                JsonDataReader.get(
                        "nonExistingEmployee",
                        "employeeName"
                );

        pimPage.searchEmployee(employeeName);

        Assert.assertTrue(
                pimPage.isNoRecordsFoundDisplayed(),
                "No Records Found"
        );
    }



    @Test(
            description = "Open Add Employee page",
            groups = {"Regression"}
    )
    @Story("Open Add Employee")
    @Severity(SeverityLevel.NORMAL)
    @Description("""
            Verify that the Add Employee page can be opened
            from the PIM module and contains First Name and
            Last Name fields.
            """)
    public void openAddEmployeeTest() {

        loginAsAdmin();

        navigateToPIM();

        pimPage.openAddEmployee();

        Assert.assertTrue(
                DriverManager.getDriver()
                        .getCurrentUrl()
                        .contains("/pim/addEmployee"),
                "URL should contain /pim/addEmployee"
        );

        Assert.assertTrue(
                pimPage.isFirstNameDisplayed(),
                "First Name field should be displayed"
        );

        Assert.assertTrue(
                pimPage.isLastNameDisplayed(),
                "Last Name field should be displayed"
        );
    }

    @Test(
            description = "Validate required First Name field",
            groups = {"Regression"}
    )
    @Story("Add Employee Required Field Validation")
    @Severity(SeverityLevel.NORMAL)
    @Description("""
            Verify that the First Name field is required when
            creating a new employee.
            """)
    public void addEmployeeWithEmptyFirstNameTest() {

        loginAsAdmin();

        navigateToPIM();

        pimPage.openAddEmployee();

        pimPage.enterLastName("TestLastName");

        pimPage.clickSave();

        Assert.assertTrue(
                pimPage.isRequiredMessageDisplayed(),
                "Required validation should be displayed under First Name"
        );
    }

    @Test(
            description = "Add a new employee successfully",
            groups = {"Regression", "E2E"}
    )
    @Story("Create New Employee")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            End-to-end verification of creating a new employee,
            opening the Personal Details page, navigating back
            to Employee List, searching for the employee, and
            verifying that the employee appears in the results.
            """)
    public void addEmployeeSuccessfullyTest() {

        loginAsAdmin();

        navigateToPIM();

        pimPage.openAddEmployee();

        String firstName =
                JsonDataReader.get(
                        "newEmployee",
                        "firstName"
                );

        String lastName =
                JsonDataReader.get(
                        "newEmployee",
                        "lastName"
                );

        pimPage.addEmployee(
                firstName,
                lastName
        );

        Assert.assertTrue(
                pimPage.isPersonalDetailsDisplayed(),
                "Personal Details page should be displayed"
        );

        Assert.assertTrue(
                DriverManager.getDriver()
                        .getCurrentUrl()
                        .contains("/pim/viewPersonalDetails"),
                "URL should contain viewPersonalDetails"
        );

        navigateToPIM();

        pimPage.openEmployeeList();

        String employeeName =
                firstName + " " + lastName;

        pimPage.searchEmployee(employeeName);

        Assert.assertTrue(
                pimPage.isEmployeeDisplayed(employeeName),
                "New employee should appear in Employee List"
        );
    }
}