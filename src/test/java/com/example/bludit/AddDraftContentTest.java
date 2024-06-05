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

public class AddDraftContentTest {

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
    public void testAddDraftContent() {
        bluditPage.login("admin", "password");

        contentPage.clickNewContent();
        contentPage.enterContentTitle("Draft Content");
        contentPage.clickSaveAsDraft();

        assertTrue(contentPage.isDraftContentDisplayed("Draft Content"));

        bluditPage.logout();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
