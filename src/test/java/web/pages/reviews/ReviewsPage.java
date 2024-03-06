package web.pages.reviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.BasePage;

public class ReviewsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'View Reviews')]")
    WebElement reviewsPageTitle;

    public ReviewsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isReviewsPageTitleVisible() {
        return wait.until(ExpectedConditions.visibilityOf(reviewsPageTitle)).isDisplayed();
    }
}