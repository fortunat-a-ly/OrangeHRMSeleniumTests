package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage extends Page {

    private final By adminMenuItem = By.className("oxd-main-menu-item-wrapper");

    // Constructor
    public WelcomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAdminMenuItem() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(adminMenuItem));
        element.click();
    }

    @Override
    public AdminPage nextPage() {
        return new AdminPage(driver, wait);
    }
}
