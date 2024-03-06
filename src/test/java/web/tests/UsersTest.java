package web.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.BaseTest;
import web.pages.home.HomePage;
import web.pages.login.LoginPage;
import web.pages.users.UsersPage;

import java.io.IOException;

import static web.common.TestData.NAME_IN_TABLE;

@Test
public class UsersTest extends BaseTest {

    private UsersPage usersPage;

    @BeforeMethod
    public void setup() throws IOException {
        super.setup();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterLoginDetails(customConfig.getUsername(), customConfig.getPassword());
        HomePage homePage = new HomePage(getDriver());
        homePage.clickUsersNavLink();
        usersPage = new UsersPage(getDriver());
    }

    @Test
    @Description("As a FE user I want to search for a user in the user table.")
    public void testSearchUserTable() {
        usersPage.searchForUser(NAME_IN_TABLE);
        Assert.assertTrue(usersPage.isNamePresent(NAME_IN_TABLE));
    }
}