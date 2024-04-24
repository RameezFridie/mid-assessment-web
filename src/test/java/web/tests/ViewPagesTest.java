package web.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.BaseTest;
import web.pages.home.HomePage;
import web.pages.login.LoginPage;
import web.pages.reports.ReportsPage;
import web.pages.reviews.ReviewsPage;

import java.io.IOException;

@Test
public class ViewPagesTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setup() throws IOException {
        super.setup();
        LoginPage loginPage = new LoginPage(driver);
        homePage = loginPage.loginUser(customConfig.getUsername(), customConfig.getPassword());
    }

    @Description("As a FE user I want to verify the visibility of the Reports page title.")
    public void testReportsPageVisibility() {
        ReportsPage reportsPage = homePage.clickReportsNavLink();
        Assert.assertTrue(reportsPage.isReportsPageTitleVisible());
    }

    @Description("As a FE user I want to verify the visibility of the Reviews page title.")
    public void testReviewsPageVisibility() {
        ReviewsPage reviewsPage = homePage.clickReviewsNavLink();
        Assert.assertTrue(reviewsPage.isReviewsPageTitleVisible());
    }
}