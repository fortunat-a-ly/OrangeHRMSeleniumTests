# OrangeHRMSeleniumTests

This readme provides instructions on setting up and running Cucumber JUnit tests with Selenium step definitions for OrangeHRM website in Chrome browser.
Refer to this website: https://opensource-demo.orangehrmlive.com/

## Prerequisites

- Java Development Kit (JDK) installed
- Java IDE (Integrated Development Environment)
- Maven or Gradle build tool installed

## Getting Started

Follow these steps to run Cucumber JUnit tests:

1. Clone or download the project repository to your local machine.
2. Open your preferred IDE (e.g., IntelliJ IDEA, Eclipse) and import the project.
3. Ensure that the project's dependencies are resolved by either letting Maven automatically download them or manually including the required JAR files.
4. Download browser drivers. Go to the Page class and configure the driver of whichever browser you need instead of Chrome driver.

## Running Tests

1. Locate the directory where the Cucumber feature files are stored - src/test/resources. These files have the .feature extension and contain the test scenarios written in Gherkin syntax.
2. Open a terminal or command prompt and navigate to the project's root directory. Run the Cucumber JUnit tests using the following command: mvn test.
3. Or open the test runner class TestRunner. Right-click on the class and select "Run" or "Run as JUnit test" depending on your IDE.
4. The test execution will start, and the results will be displayed in the console.
5. You can also check test reports in the /allure-results folder.
