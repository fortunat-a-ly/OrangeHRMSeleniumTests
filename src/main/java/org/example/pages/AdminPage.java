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
        List<WebElement> parentElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.oxd-table-row")));

        System.out.println(parentElements.size());
        // Initialize a variable to store the selected parent element
        WebElement selectedParentElement = null;

        // Iterate over the parent elements and find the one with matching descendant text
        for (WebElement parentElement : parentElements) {
            // Check if any descendant contains the desired text
            boolean hasMatchingDescendant = jobTitle.equals(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.oxd-table-cell > div"))).get(1).getText());
            //     boolean hasMatchingDescendant = jobTitle.equals(parentElement.findElements(By.cssSelector("div.oxd-table-cell > div")).get(1).getText());

            if (hasMatchingDescendant) {
                // If a descendant contains the text, set the selected parent element and break the loop
                selectedParentElement = parentElement;
                break;
            }
        }

        // Perform actions on the selected parent element
        assert selectedParentElement != null;
        selectedParentElement.findElement(By.cssSelector("div.oxd-table-cell > div.oxd-table-cell-actions > button"))
                .click();

    }

    @Override
    public Page nextPage() {
        return null;
    }
}
