package com.example.bludit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POs.BluditPage;
import POs.UserPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeUserPasswordTest {

    private WebDriver driver;
    private BluditPage bluditPage;
    private UserPage userPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
        bluditPage = new BluditPage(driver);
        userPage = new UserPage(driver);
    }

    @Test
    public void testChangeUserPassword() {
        bluditPage.login("admin", "password");

        userPage.clickUsersLink();
        userPage.clickUserLink("usertest");
        userPage.clickChangePasswordLink();
        userPage.enterNewPassword("newpassword");
        userPage.confirmNewPassword("newpassword");
        userPage.clickSavePasswordButton();

        assertTrue(userPage.isAlertDisplayed("The changes have been saved"));

        bluditPage.logout();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
