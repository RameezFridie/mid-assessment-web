package web.pages.templates;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.BasePage;

public class TemplatesPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'View Templates')]")
    WebElement templatesPageTitle;

    public TemplatesPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isTemplatesPageTitleVisible() {
        return wait.until(ExpectedConditions.visibilityOf(templatesPageTitle)).isDisplayed();
    }
}