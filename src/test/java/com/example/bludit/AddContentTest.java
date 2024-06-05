package com.example.bludit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POs.BluditPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddContentTest {

    private WebDriver driver;
    private BluditPage bluditPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
        bluditPage = new BluditPage(driver);
    }

    @Test
    public void testAddContent() {
        driver.get("http://localhost:8080/admin/");

        bluditPage.login("admin", "password");

        bluditPage.clickNewContent();

        bluditPage.enterContentTitle("Test Content");

        bluditPage.clickSave();

        assertTrue(bluditPage.isContentPublished("Test Content"));

        bluditPage.logout();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
