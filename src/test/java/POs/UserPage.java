package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddNewUserLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add a new user"))).click();
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jsnew_username"))).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jsnew_password"))).sendKeys(password);
    }

    public void confirmPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jsconfirm_password"))).sendKeys(password);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jsemail"))).sendKeys(email);
    }

    public void selectRole(String role) {
        Select roleDropdown = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jsrole"))));
        roleDropdown.selectByVisibleText(role);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']"))).click();
    }

    public boolean isUserPresent(String username) {
        return driver.getPageSource().contains(username);
    }

    public void clickUsersLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Users"))).click();
    }

}
