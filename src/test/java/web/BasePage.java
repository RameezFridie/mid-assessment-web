package web;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriverWait wait;
    protected final Actions actions;
    protected final RemoteWebDriver driver;

    public BasePage(RemoteWebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }
}