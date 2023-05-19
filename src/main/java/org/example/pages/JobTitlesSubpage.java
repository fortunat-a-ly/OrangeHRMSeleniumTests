package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class JobTitlesSubpage extends Page {

    private final By jobTitlesAddButton = By.className("oxd-button");

    @Override
    public AddJobSubpage nextPage() {
        return new AddJobSubpage(driver, wait);
    }

    public JobTitlesSubpage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAddJobButton() {
        WebElement usernameField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitlesAddButton));
        usernameField2.click();
    }

    public void jobOfferExists(String jobTitle, String jobDescription, String jobNote) {
        List<WebElement> parentElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("oxd-table-row")));
        List<WebElement> jobTitles = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("oxd-table-cell")));
        System.out.println(parentElements.size());

        WebElement selectedParentElement = null;

        for (int i = 0; i < parentElements.size(); i++) {
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
}
