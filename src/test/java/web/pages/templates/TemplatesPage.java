package web.pages.templates;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.BasePage;

public class TemplatesPage extends BasePage {

    public TemplatesPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickTemplateTitle(String username) {
        String nameInListXpath = "(//td[contains(text(), '" + username + "')])[1]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nameInListXpath))).click();
    }

    public boolean isTemplatesPageMessageVisible(String message) {
        String messageTextXpath = "//td[contains(text(), '" + message + "')]";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(messageTextXpath))).isDisplayed();
    }
}