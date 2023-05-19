package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddJobSubpage extends Page {

    private final By jobTitleField = By.cssSelector(".oxd-input-group > div > input");
    private final By jobDescriptionField = By.cssSelector("textarea.oxd-textarea:nth-of-type(1)");
    private final By jobNoteField = By.cssSelector("div.oxd-form-row:nth-of-type(4) > div > div > textarea");
    private final By jobSaveButton = By.cssSelector("button.oxd-button[type='submit']");

    @Override
    public JobTitlesSubpage nextPage() {
        return new JobTitlesSubpage(driver, wait);
    }

    public AddJobSubpage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void fillJobTitleField(String jobTitle) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleField));
        element.sendKeys(jobTitle);
    }

    public void fillJobDescriptionField(String jobDescription) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(jobDescriptionField));
        element.sendKeys(jobDescription);
    }
    public void fillJobNoteField(String jobNote) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(jobNoteField));
        element.sendKeys(jobNote);
    }
    public void clickSaveJobButton() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(jobSaveButton));
        element.click();
    }
}
