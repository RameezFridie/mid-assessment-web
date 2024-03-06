package web.pages.reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.BasePage;

public class ReportsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'View Reports')]")
    WebElement reportsPageTitle;

    public ReportsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isReportsPageTitleVisible() {
        return wait.until(ExpectedConditions.visibilityOf(reportsPageTitle)).isDisplayed();
    }
}