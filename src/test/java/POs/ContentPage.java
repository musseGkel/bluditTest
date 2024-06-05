package POs;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
}
