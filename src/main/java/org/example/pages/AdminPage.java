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

    public void clickAddJobButton() {
        WebElement usernameField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitlesAddButton));
        usernameField2.click();
    }

    public void fillJobTitleField(String jobTitle) {
        WebElement usernameField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleField));
        usernameField2.sendKeys(jobTitle);
    }

    public void fillJobDescriptionField(String jobDescription) {
        WebElement usernameField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(jobDescriptionField));
        usernameField2.sendKeys(jobDescription);
    }
    public void fillJobNoteField(String jobNote) {
        WebElement usernameField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(jobNoteField));
        usernameField2.sendKeys(jobNote);
    }
    public void clickSaveJobButton() {
        WebElement usernameField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(jobSaveButton));
        usernameField2.click();
    }

    public void jobOfferExists(String jobTitle, String jobDescription, String jobNote) {
        List<WebElement> parentElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("oxd-table-row")));
        List<WebElement> jobTitles = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("oxd-table-cell")));
        System.out.println(parentElements.size());

        WebElement selectedParentElement = null;


        // Iterate over the parent elements and find the one with matching descendant text
        for (int i = 0; i < parentElements.size(); i++) {
           // WebElement cell = parentElements.get(i).findElement(By.className("oxd-table-cell"));
            boolean hasMatchingDescendant = jobTitle.equals(jobTitles.get(i).getText());

            if (hasMatchingDescendant) {
                selectedParentElement = parentElements.get(i);
                break;
            }
        }

        assert selectedParentElement != null;
        selectedParentElement.findElement(By.cssSelector("div.oxd-table-cell > div.oxd-table-cell-actions > button"))
                .click();

    }

    public void deleteButton(String jobTitle) {
        List<WebElement> buttons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.oxd-table-cell > div.oxd-table-cell-actions > button")));
        List<WebElement> jobTitles = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("oxd-table-cell")));

        for (int i = 0; i < jobTitles.size(); i++) {
            if(jobTitle.equals(jobTitles.get(i).getText())) {
                buttons.get(i).click();
                break;
            }

        }

    }

    public void clickYesInPopupDialog() {
        WebElement usernameField2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("oxd-sheet > orangehrm-modal-footer > button:nth-child(2)")));
        usernameField2.click();
    }

    public void isJobDeleted(String jobTitle) {
        List<WebElement> jobTitles = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("oxd-table-cell")));

        boolean isRemoved = true;
        for (WebElement title : jobTitles) {
            if (jobTitle.equals(title.getText())) {
                isRemoved = false;
                break;
            }

        }

        assert isRemoved;
    }

    @Override
    public Page nextPage() {
        return null;
    }
}
