package web.pages.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.BasePage;

public class UsersPage extends BasePage {

    @FindBy(css = "[data-qa='search-input']")
    WebElement userSearchInputField;

    @FindBy(css = "[data-qa='3-pagination-button']")
    WebElement pageThreePaginationLink;

    public UsersPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchForUser(String username) {
        wait.until(ExpectedConditions.visibilityOf(userSearchInputField)).sendKeys(username);
    }

    public void navigateToPageThree() {
        wait.until(ExpectedConditions.elementToBeClickable(pageThreePaginationLink)).click();
    }

    public boolean isNamePresent(String username) {
        String nameInListXpath = "//td[contains(text(),'" + username + "')]";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nameInListXpath))).isDisplayed();
    }
}