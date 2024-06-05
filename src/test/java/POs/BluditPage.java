package POs;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BluditPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BluditPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://localhost:8080/admin/");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password) {
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys(username);
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys(password);
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/form[1]/div[4]/button[1]")).click();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out"))).click();
    }
}
