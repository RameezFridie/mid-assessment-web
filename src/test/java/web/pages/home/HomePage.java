package web.pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.BasePage;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Home')]")
    WebElement homepageTitle;

    @FindBy(css = "[data-qa='users-app-link']")
    WebElement usersNavLink;

    @FindBy(css = "[data-qa='reports-app-link']")
    WebElement reportsNavLink;

    @FindBy(css = "[data-qa='reviews-app-link']")
    WebElement reviewsNavLink;

    @FindBy(css = "[data-qa='templates-app-link']")
    WebElement templatesNavLink;

    public HomePage(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickUsersNavLink() {
        wait.until(ExpectedConditions.elementToBeClickable(usersNavLink)).click();
    }

    public void clickReportsNavLink() {
        wait.until(ExpectedConditions.elementToBeClickable(reportsNavLink)).click();
    }

    public void clickReviewsNavLink() {
        wait.until(ExpectedConditions.elementToBeClickable(reviewsNavLink)).click();
    }

    public void clickTemplatesNavLink() {
        wait.until(ExpectedConditions.elementToBeClickable(templatesNavLink)).click();
    }

    public boolean isHomepageTitleVisible() {
        return wait.until(ExpectedConditions.visibilityOf(homepageTitle)).isDisplayed();
    }
}