# OrangeHRM Web Automation Framework 

A Selenium WebDriver automation framework for testing the **OrangeHRM** web application using **Java, TestNG, Maven, Page Object Model (POM), JSON test data, and Allure Reporting**.

The framework provides reusable page objects, organized test suites, meaningful Allure test documentation, and failure screenshots.

---

## 📌 Project Overview

This project automates key OrangeHRM functional areas including:

- Authentication / Login
- Admin & User Management
- PIM / Employee Management
- Sidebar Navigation
- Footer & UI Branding
- Required-field validation
- Invalid-login validation

The framework uses the **Page Object Model** to separate test logic from UI locators and reusable actions.

---

## 🛠️ Technologies & Tools

| Technology / Tool | Purpose |
|---|---|
| Java | Programming language |
| Selenium WebDriver | Web UI automation |
| TestNG | Test execution and assertions |
| Maven | Build and dependency management |
| Page Object Model | Framework design pattern |
| Jackson | Reading JSON test data |
| JSON | Data-driven test data |
| Allure Report | Test execution reporting |
| Git & GitHub | Version control |
| IntelliJ IDEA | Development environment |

---

## 🏗️ Framework Architecture

```text
OrangeHRM
│
├── src
│   ├── main
│   │   └── java
│   │       ├── Base
│   │       │   └── BaseTest.java
│   │       ├── Pages
│   │       │   ├── LoginPage.java
│   │       │   ├── AdminPage.java
│   │       │   ├── PIMPage.java
│   │       │   ├── SidebarPage.java
│   │       │   └── FooterPage.java
│   │       ├── Utilities
│   │       │   ├── DriverManager.java
│   │       │   ├── JsonDataReader.java
│   │       │   └── CMDRunner.java
│   │       └── Listeners
│   │           ├── CustomTestListener.java
│   │           └── CustomeExecutionListener.java
│   │
│   └── test
│       ├── java
│       │   └── Tests
│       │       ├── LoginTest.java
│       │       ├── AdminTest.java
│       │       ├── PIMTest.java
│       │       ├── SidebarTest.java
│       │       └── FooterTest.java
│       └── resources
│           └── testData.json
│
├── allure-report/
├── pom.xml
└── README.md
```

> The exact package/file structure can vary depending on the final project version.

---

# 🧪 Automated Test Coverage

## 🔐 Login Tests

The Login module covers:

- Login with valid credentials
- Login with invalid credentials
- Empty username and password validation
- Invalid credentials error-message validation
- Required-field validation

Example Allure documentation:

```java
@Test(
    description = "Login with invalid credentials",
    groups = {"Regression"}
)
@Story("Invalid Login")
@Severity(SeverityLevel.CRITICAL)
@Description("Verify that an appropriate error message is displayed when invalid username and password are entered.")
```

---

## 👤 Admin Tests

The Admin module covers:

- Opening the Admin section
- Opening User Management
- Opening the Add User page
- Required-field validation
- User-management navigation

---

## 👥 PIM Tests

The PIM module covers:

- Opening the PIM section
- Opening the Add Employee page
- Adding a new employee successfully
- Searching for an existing employee
- Searching for a non-existing employee
- Required-field validation

---

## 🧭 Sidebar Tests

The Sidebar test verifies that the expected OrangeHRM navigation menu items are available for an authenticated user.

Allure story:

**Verify sidebar menu items**

---

## 🏷️ Footer Tests

The Footer test verifies the OrangeHRM footer branding and expected footer information.

Example:

**Verify OrangeHRM footer branding link**

---

# 📊 Allure Reporting

Allure is integrated with TestNG to provide detailed and readable test execution reports.

The report includes:

- Test cases
- Execution status
- Test descriptions
- Test steps
- Test stories
- Severity levels
- Test groups
- Parameters
- Setup and teardown
- Execution duration
- Failure information
- Failure screenshots

A custom TestNG execution listener is used to generate the Allure report after test execution.

---

# 📝 Allure Annotations

The tests use meaningful Allure annotations to make the report easier to understand.

Examples:

```java
@Story("Invalid Login")
@Severity(SeverityLevel.CRITICAL)
@Description("Verify that invalid credentials display an appropriate error message.")
```

Meaningful steps can also be added using:

```java
@Step("Enter username")
@Step("Enter password")
@Step("Click Login button")
@Step("Verify invalid credentials message")
```

This makes the Allure report describe the actual business flow instead of only showing Java method names.

---

# 📸 Allure Report Screenshots

## Allure Behaviors

The Behaviors section groups tests by feature and story, making it easy to understand the functional areas covered by the automation suite.

<p align="center">
  <img src="docs/Allure Behaviors.png" width="700">
</p>

---

## Login Test Details

The Allure test details page shows the test status, severity, description, parameters, setup, test steps, and teardown.

<p align="center">
  <img src="docs//Allure Behaviors 2.png" width="700">
</p>

---

## Allure Overview

The Overview dashboard provides a visual summary of the test execution, including execution status and duration information.

<p align="center">
  <img src="docs/Allure Overview.png" width="700">
</p>

---

## Allure Suites

The Suites section organizes the automated tests by their TestNG test classes.

<p align="center">
  <img src="docs/Login Test Details.png" width="700">
</p>

---
# 📈 Test Execution

The provided Allure report screenshots show a successful execution with the tests displayed as passed.

The report provides visibility into:

- Passed tests
- Failed tests
- Test duration
- Severity
- Test suites
- Behaviors
- Individual test details

---

# 🗂️ Test Data Management

Test data is stored separately in:

```text
src/test/resources/testData.json
```

A reusable `JsonDataReader` utility reads the JSON file using Jackson.

Example:

```java
JsonDataReader.get("invalidLogin", "username");
JsonDataReader.get("invalidLogin", "password");
```

This keeps test data separate from test implementation and makes the framework easier to maintain.

---

# 🔧 Reusable Base Page

Common Selenium operations are centralized in the Base Page, including:

- Waiting for element visibility
- Waiting for element to be clickable
- Clicking elements
- Entering text
- Retrieving element text

This reduces code duplication across Page Object classes.

---

# 📷 Failure Screenshots

A custom TestNG listener captures a screenshot when a test fails and attaches it to the Allure report.

Example:

```java
@Override
public void onTestFailure(ITestResult result) {
    try {
        if (DriverManager.getDriver() != null) {

            byte[] screenshot =
                    ((TakesScreenshot) DriverManager.getDriver())
                            .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    "Failure Screenshot",
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    ".png"
            );
        }
    } catch (Exception e) {
        System.out.println(
                "Failed to capture screenshot: "
                        + e.getMessage()
        );
    }
}
```

---

# ▶️ How to Run the Project

## 1. Clone the repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

## 2. Open the project

Open the project using IntelliJ IDEA.

## 3. Install Maven dependencies

```bash
mvn clean install
```

## 4. Run the tests

```bash
mvn test
```

---

# 📊 Generate Allure Report

After running the tests, Allure result files are generated under:

```text
target/allure-results
```

Generate the static report with:

```bash
allure generate target/allure-results -o allure-report --clean --single-file
```

The generated report is placed in:

```text
allure-report
```

To open the report locally:

```bash
allure open allure-report
```

> `target/allure-results` should not be committed to GitHub.

---

# 📦 GitHub Repository

The repository contains:

- Automation source code
- Test classes
- Page Objects
- Utilities
- Test data
- TestNG configuration
- Allure report
- README documentation

The generated `allure-report` folder can be committed to the repository so the static report is available as part of the project documentation.

The temporary `allure-results` folder should remain excluded from Git.

Recommended `.gitignore`:

```gitignore
target/
allure-results/
```

If `allure-report` is generated outside `target`, it can be tracked normally.

---

# 🎯 Key Framework Features

✅ Selenium WebDriver automation  
✅ Java-based framework  
✅ TestNG test execution  
✅ Page Object Model  
✅ Explicit waits  
✅ Reusable Base Page methods  
✅ JSON data-driven testing  
✅ Jackson JSON reader  
✅ TestNG groups  
✅ Allure reporting  
✅ Allure test descriptions and stories  
✅ Severity classification  
✅ Meaningful test steps  
✅ Failure screenshots  
✅ Custom TestNG listeners  
✅ Maven project structure  
✅ Git/GitHub version control  

---

# 🚫 Optional Requirements Not Implemented

The following optional features are **not implemented** in the current version:

- Log4j2 logging
- TestNG `IRetryAnalyzer` retry mechanism

They can be added as future enhancements.

---

# 🔮 Future Enhancements

Possible future improvements include:

- Add Log4j2 framework logging
- Add TestNG retry mechanism
- Add cross-browser testing
- Add parallel execution
- Add CI/CD pipeline using GitHub Actions
- Improve test-data management
- Add more OrangeHRM modules and scenarios

---

# 👩‍💻 Author

**Sara Ali**

Software Testing / QA Automation

`Java` · `Selenium` · `TestNG` · `POM` · `Maven` · `JSON` · `Allure` · `Git`

---

## ⭐ Project Purpose

This project demonstrates practical knowledge of **web automation testing, framework design, Selenium WebDriver, TestNG, Page Object Model, data-driven testing, and professional test reporting**.
