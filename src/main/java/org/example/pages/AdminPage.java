package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminPage extends Page {

    private final By adminMenuItem = By.xpath("(//*[@class='oxd-topbar-body-nav-tab-item'])[2]");
    private final By jobTitlesSubmenuLink = By.className("oxd-topbar-body-nav-tab-link");

    private final By jobTitlesAddButton = By.className("oxd-button");

    private final By jobTitleField = By.cssSelector(".oxd-input-group > div > input");
    private final By jobDescriptionField = By.cssSelector("textarea.oxd-textarea:nth-of-type(1)");
    private final By jobNoteField = By.cssSelector("div.oxd-form-row:nth-of-type(4) > div > div > textarea");
    private final By jobSaveButton = By.cssSelector("button.oxd-button[type='submit']");
    private final By createdJobItem = By.xpath("//div.card-center[descendant-or-self::*[text()='Java developer']]");

    public AdminPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openJobSubmenu() {
        WebElement usernameField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(adminMenuItem));
        usernameField2.click();
    }

    public void clickJobTitles() {
        WebElement usernameField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitlesSubmenuLink));
        usernameField2.click();
    }

    @Override
    public JobTitlesSubpage nextPage() {
        return new JobTitlesSubpage(driver, wait);
    }
}
