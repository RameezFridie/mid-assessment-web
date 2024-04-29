package web.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.BaseTest;
import web.pages.home.HomePage;
import web.pages.login.LoginPage;
import web.pages.templates.TemplatesPage;

import static web.common.TestData.NAME_IN_TEMPLATES_TABLE;
import static web.common.TestData.TEMPLATE_MESSAGE;

@Test
public class TemplatesTest extends BaseTest {

    @Description("As a FE user I want to view a template on the template table.")
    public void testViewTemplate() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.loginUser(customConfig.getUsername(), customConfig.getPassword());
        TemplatesPage templatesPage = homePage.clickTemplatesNavLink();
        templatesPage.clickTemplateTitle(NAME_IN_TEMPLATES_TABLE);
        Assert.assertTrue(templatesPage.isTemplatesPageMessageVisible(TEMPLATE_MESSAGE));
    }
}
