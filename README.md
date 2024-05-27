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

### Running

Updates -
The Java framework utilizes Gradle as the primary build tool. To run the tests:

- On a Windows operating system, navigate to the project root in your command line.
- Run the command: `gradle clean test`
- On a Mac machine, you can run: `./gradlew clean test`
- In the BaseTest class change the browser to your desired browser in order to run.

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

# Example code to change browser in BaseTest class
initializeDriver(BrowserType.EDGE);
OR
initializeDriver(BrowserType.CHROME);
OR
initializeDriver(BrowserType.FIREFOX);