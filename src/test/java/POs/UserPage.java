package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void clickUserLink(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), '" + username + "')]")))
                .click();
    }

    public void clickChangePasswordLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Change password"))).click();
    }

    public void enterNewPassword(String newPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jsnew_password"))).sendKeys(newPassword);
    }

    public void confirmNewPassword(String newPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jsconfirm_password"))).sendKeys(newPassword);
    }

    public void clickSavePasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Save')]"))).click();
    }

    public boolean isAlertDisplayed(String alertMessage) {
        WebElement alertElement = wait
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("alert")));
        String alertText = alertElement.getText().trim();
        return alertText.equals(alertText);
    }

    public void clickFirstUsername() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//tbody/tr[1]/td[1]/a"))).click();
    }

    public void enterFacebookLink(String facebookLink) {
        WebElement facebookField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("jsfacebook")));
        facebookField.clear();
        facebookField.sendKeys(facebookLink);
    }

    public void enterInstagramLink(String instagramLink) {
        WebElement instagramField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("jsinstagram")));
        instagramField.clear();
        instagramField.sendKeys(instagramLink);
    }

    public String getFacebookLink() {
        WebElement facebookField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("jsfacebook")));
        return facebookField.getAttribute("value");
    }

    public String getInstagramLink() {
        WebElement instagramField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("jsinstagram")));
        return instagramField.getAttribute("value");
    }
}