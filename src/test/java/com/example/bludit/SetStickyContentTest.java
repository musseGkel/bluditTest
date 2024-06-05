package com.example.bludit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POs.BluditPage;
import POs.ContentPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetStickyContentTest {

    private WebDriver driver;
    private BluditPage bluditPage;
    private ContentPage contentPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
        bluditPage = new BluditPage(driver);
        contentPage = new ContentPage(driver);
    }

    @Test
    public void testSetStickyContent() {
        bluditPage.login("admin", "password");

        contentPage.clickContentLink();
        contentPage.clickStickyContentLink();
        contentPage.clickAdvancedButton();
        contentPage.selectStatus("Sticky");
        contentPage.clickSave();
        contentPage.clickContentLink();

        assertTrue(contentPage.isStickyContentDisplayed("Set up your new site"));

        bluditPage.logout();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
