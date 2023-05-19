package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePage extends Page {

    private final By adminMenuItem = By.className("oxd-main-menu-item-wrapper");

    // Constructor
    public WelcomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAdminMenuItem() {
        WebElement usernameField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(adminMenuItem));
        usernameField2.click();
    }

    @Override
    public Page nextPage() {
        return new AdminPage(driver, wait);
    }
}
