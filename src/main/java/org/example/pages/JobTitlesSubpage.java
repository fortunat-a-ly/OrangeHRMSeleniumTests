package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class JobTitlesSubpage extends Page {

    private final By jobTitlesAddButton = By.className("oxd-button");
    private final By jobRowSelector = By.className("oxd-table-row");
    private final By jobTitleSelector = By.className("oxd-table-cell");
    private final By jobBinButtonSelector = By.cssSelector("div.oxd-table-cell div.oxd-table-cell-actions button.oxd-icon-button:nth-child(1)");
    private final By popupYesButtonSelector = By.cssSelector(".oxd-sheet > .orangehrm-modal-footer > button:nth-child(2)");

    @Override
    public AddJobSubpage nextPage() {
        return new AddJobSubpage(driver, wait);
    }

    public JobTitlesSubpage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAddJobButton() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitlesAddButton));
        element.click();
    }
    public void jobOfferExists(String jobTitle, String jobDescription, String jobNote) {
        List<WebElement> parentElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jobRowSelector));
        List<WebElement> jobTitles = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jobTitleSelector));
        // System.out.println(parentElements.size());
        // System.out.println(jobTitles.size());

        WebElement selectedParentElement = null;

        for (int i = 0; i < parentElements.size(); i++) {
            boolean hasMatchingDescendant = jobTitle.equals(jobTitles.get(i).getText());

            if (hasMatchingDescendant) {
                selectedParentElement = parentElements.get(i);
                break;
            }
        }

        assert selectedParentElement != null;
    }

    public void deleteButton(String jobTitle) {
        List<WebElement> buttons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jobBinButtonSelector));
        List<WebElement> jobTitles = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jobTitleSelector));

        //System.out.println(buttons.size());
        //System.out.println(jobTitles.size());

        for (int i = 0; i < buttons.size(); i++) {
            if(jobTitle.equals(jobTitles.get(i).getText())) {
                buttons.get(i).click();
                break;
            }

        }

    }

    public void clickYesInPopupDialog() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(popupYesButtonSelector));
        element.click();
    }

    public void isJobDeleted(String jobTitle) {
        List<WebElement> jobTitles = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jobTitleSelector));

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
