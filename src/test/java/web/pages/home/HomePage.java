package web.pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.BasePage;
import web.pages.reports.ReportsPage;
import web.pages.reviews.ReviewsPage;
import web.pages.templates.TemplatesPage;
import web.pages.users.UsersPage;

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

    public UsersPage clickUsersNavLink() {
        wait.until(ExpectedConditions.elementToBeClickable(usersNavLink)).click();
        return new UsersPage(driver);
    }

    public ReportsPage clickReportsNavLink() {
        wait.until(ExpectedConditions.elementToBeClickable(reportsNavLink)).click();
        return new ReportsPage(driver);
    }

    public ReviewsPage clickReviewsNavLink() {
        wait.until(ExpectedConditions.elementToBeClickable(reviewsNavLink)).click();
        return new ReviewsPage(driver);
    }

    public TemplatesPage clickTemplatesNavLink() {
        wait.until(ExpectedConditions.elementToBeClickable(templatesNavLink)).click();
        return new TemplatesPage(driver);
    }

    public boolean isHomepageTitleVisible() {
        return wait.until(ExpectedConditions.visibilityOf(homepageTitle)).isDisplayed();
    }
}