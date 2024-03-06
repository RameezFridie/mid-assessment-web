package web.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.BasePage;

public class LoginPage extends BasePage {

    @FindBy(css = "[data-qa='user-name-text-input-field']")
    WebElement usernameInputField;

    @FindBy(css = "[data-qa='password-password-input-field']")
    WebElement passwordInputField;

    @FindBy(css = "[data-qa='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(), 'Username is invalid')]")
    WebElement invalidUsernameText;

    public LoginPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void enterLoginDetails(String username, String password) {
        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isErrorMessageVisible() {
        return wait.until(ExpectedConditions.visibilityOf(invalidUsernameText)).isDisplayed();
    }
}