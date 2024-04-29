package web;

import lombok.Getter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import web.common.TestData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseTest {

    protected static CustomConfig customConfig;

    @Getter
    protected static RemoteWebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        customConfig = new CustomConfig(loadProperties());
        BrowserType browserType = BrowserType.valueOf(customConfig.getBrowser());
        initializeDriver(browserType);
        navigateToUrl();
    }

    private void initializeDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
        maximizeWindow();
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }

    private void navigateToUrl() {
        driver.get(customConfig.getWebUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream file = new FileInputStream(TestData.DATA_PATH)) {
            properties.load(file);
        }
        return properties;
    }

    public enum BrowserType {
        CHROME, FIREFOX, EDGE
    }
}