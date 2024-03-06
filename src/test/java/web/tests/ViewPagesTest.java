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
import web.pages.templates.TemplatesPage;

import java.io.IOException;

@Test
public class ViewPagesTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setup() throws IOException {
        super.setup();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterLoginDetails(customConfig.getUsername(), customConfig.getPassword());
        homePage = new HomePage(getDriver());
    }

    @Description("As a FE user I want to verify the visibility of the Reports page title.")
    public void testReportsPageVisibility() {
        homePage.clickReportsNavLink();
        ReportsPage reportsPage = new ReportsPage(getDriver());
        Assert.assertTrue(reportsPage.isReportsPageTitleVisible());
    }

    @Description("As a FE user I want to verify the visibility of the Reviews page title.")
    public void testReviewsPageVisibility() {
        homePage.clickReviewsNavLink();
        ReviewsPage reviewsPage = new ReviewsPage(getDriver());
        Assert.assertTrue(reviewsPage.isReviewsPageTitleVisible());
    }
}