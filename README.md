# Career Development System (CDS) Web Automation

## Mid SDET Assessment Section 4

This repository demonstrates the author's proficiency in web automation and includes the following:

1. Java Automation Framework using Selenium.

## Requirements

- Java 11 (JDK 11 or higher)
- 1 of 3 Browsers(Chrome, Edge and FireFox)
- Access to Global Kinetic VPN

## System Under Test (SUT)

The System Under Test (SUT) for this project is the [CDM Website](http://dockerdev:8801/login). A connection to the Global Kinetic Network is required to access this website.
The website is currently receiving updates. Some tests may fail.

## Installation

1. Clone the repository: `git clone https://github.com/RameezFridie/mid-assessment-web`
2. Navigate to the project root: `cd your-repo`

## Java Automation Framework

### Prerequisites

- Choose an Integrated Development Environment (IDE) for development (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code).
- Ensure the presence of a `data.properties` file to run the automation successfully.
- The `data.properties` file should contain the necessary data for the automation to run.
- Ensure that you have the `data.properties` file.

### Other Libraries

- [**Selenium WebDriver**](https://www.selenium.dev/documentation/webdriver/) to run the automation tests.
- [**Project Lombok**](https://projectlombok.org/) to get auto-generated Getter and Setter methods.
- [**TestNG**](https://testng.org/doc/) to get annotations and assertion methods in order to execute the tests.
- 
### Running

The Java framework utilizes Gradle as the primary build tool. To run the tests:

- On a Windows operating system, navigate to the project root in your command line.
- Run the command: `gradle clean test`
- On a Mac machine, you can run: `./gradlew clean test`
- In the BaseTest class change the browser to your desired browser in order to run.

### Project Structure

This project follows a certain structure, where:

- The tests are found under the **tests** package.
- The classes that provide test data are found under the **common** package.
- The **CustomConfig.java** class for configuring the `data.properties` is found under the overall web folder.
- The **SetUpWebDriver.java** class sets up the browser drivers is fount under the overall web folder.

### Reporting

Generate a test report for the last completed run:

- Run the command: `gradlew allureReport` (or `./gradlew allureReport` on Unix).
- The report will be available in the `test-report` folder. Open `index.html` in a Chrome browser for the best viewing experience.
- This report can be served on a browser using `gradlew allureServe` or `./gradlew allureServe`.

## Examples/Sample Usage

### Java Automation Framework
```bash
# Example command to run tests on Windows
gradle clean test

# Example command to run tests on Mac
./gradlew clean test