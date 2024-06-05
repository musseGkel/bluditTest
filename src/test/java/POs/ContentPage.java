package POs;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ContentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickNewContent() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New content"))).click();
    }

    public void enterContentTitle(String title) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='jstitle']"))).sendKeys(title);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//body/div[@id='bl-container']/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/button[1]")))
                .click();
    }

    public boolean isContentPublished(String title) {
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//tbody/tr[4]/td[1]/a[1]")))
                .isDisplayed();
    }

    public void clickContentLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Content"))).click();
    }

    public void clickTestContentLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Test Content"))).click();
    }

    public void clickAdvancedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//body/div[@id='bl-container']/div[1]/div[2]/form[1]/div[1]/div[2]/ul[1]/li[7]/h2[1]")))
                .click();
    }

    public void clearFriendlyUrl() {
        WebElement urlField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jsslug")));
        urlField.clear();
    }

    public void enterFriendlyUrl(String url) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jsslug"))).sendKeys(url);
    }

    public String getFriendlyUrl(String contentTitle) {
        WebElement friendlyUrlElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//tbody/tr[4]/td[3]/a[1]")));
        return friendlyUrlElement.getText();
    }

    public void clearPositionField() {
        WebElement positionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jsposition")));
        positionField.clear();
    }

    public void enterPosition(String position) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jsposition"))).sendKeys(position);
    }

    public String getPositionValue() {
        WebElement positionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='jsposition']")));

        return positionElement.getAttribute("value");
    }

}
