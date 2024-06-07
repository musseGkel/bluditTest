package com.example.bludit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POs.BluditPage;
import POs.UserPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddUserSocialLinksTest {

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
    public void testAddUserSocialLinks() {
        bluditPage.login("admin", "password");
        userPage.clickUsersLink();
        userPage.clickFirstUsername();
        userPage.enterFacebookLink("https://www.facebook.com/some_fake_user_name_52432562135863");
        userPage.enterInstagramLink("https://instagram.com/some_fake_user_name_52432562135863");
        userPage.clickSave();
        userPage.clickUsersLink();
        userPage.clickFirstUsername();
        assertEquals("https://www.facebook.com/some_fake_user_name_52432562135863", userPage.getFacebookLink());
        assertEquals("https://instagram.com/some_fake_user_name_52432562135863", userPage.getInstagramLink());
        bluditPage.logout();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
