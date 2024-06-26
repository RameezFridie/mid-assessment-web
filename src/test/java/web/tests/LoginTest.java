package web.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.BaseTest;
import web.pages.home.HomePage;
import web.pages.login.LoginPage;

import java.io.IOException;

@Test
public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setup() throws IOException {
        super.setup();
        loginPage = new LoginPage(driver);
    }

    @Description("As a FE user I want to successfully login using valid credentials.")
    public void testLogin() {
        HomePage homePage = loginPage.loginUser(customConfig.getUsername(), customConfig.getPassword());
        Assert.assertTrue(homePage.isHomepageTitleVisible());
    }

    @Description("As a FE user I want to view the error message when attempting to login with invalid credentials")
    public void testInvalidCredentialsLogin() {
        loginPage.loginUser("invalidUsername", "invalidPassword");
        Assert.assertTrue(loginPage.isErrorMessageVisible());
    }
}