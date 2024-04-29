package web;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import web.common.TestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public abstract class BaseTest {

    protected static CustomConfig customConfig;
    protected static SetUpWebDriver setUpWebDriver;
    private static final Logger LOG = getLogger(lookup().lookupClass());

    protected static RemoteWebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException {
        customConfig = new CustomConfig(loadProperties());
        setUpWebDriver = new SetUpWebDriver();
        setUpWebDriver.initializeDriver(BrowserType.valueOf(customConfig.getBrowser().toUpperCase()));
        maximizeWindow();
        navigateToUrl();
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }

    private void navigateToUrl() {
        driver.get(customConfig.getWebUrl());
    }

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream file = new FileInputStream(TestData.DATA_PATH)) {
            properties.load(file);
        }
        catch (FileNotFoundException fileNotFoundException) {
           LOG.info(String.format("Properties file not found %s", fileNotFoundException)) ;
        }
        return properties;
    }

    public enum BrowserType {
        CHROME, FIREFOX, EDGE, SAFARI
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}