package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public abstract Page nextPage();

    Page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    Page(String url) {
        configureDriver(url);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void configureDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/org/example/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // Create a new instance of ChromeDriver
        this.driver = new ChromeDriver(options);
        // Maximize the browser window
        this.driver.manage().window().maximize();
        // Launch the application URL
        this.driver.get(url);
    }

}
