package Base.pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.utils1.TestData1;

import java.time.Duration;

public class ChangePasswordPage1 {
    WebDriver driver;
    WebDriverWait wait;

    By accountLink = By.linkText("My Account");
    By changePasswordLink = By.xpath("//div[@class='box-actions']/child::*[2]");
    By currentPasswordField = By.id("current-password");
    By newPasswordField = By.id("password");
    By confirmPasswordField = By.id("password-confirmation");
    By saveButton = By.xpath("//button[@title='Save']");

    public ChangePasswordPage1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void changePassword(String currentPassword, String newPassword) {
        driver.get("https://magento.softwaretestingboard.com/customer/account/index/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 400)");

        wait.until(ExpectedConditions.visibilityOfElementLocated(changePasswordLink)).click();

        js.executeScript("window.scrollTo(0, 500)");

        driver.findElement(currentPasswordField).sendKeys(currentPassword);
        driver.findElement(newPasswordField).sendKeys(newPassword);
        driver.findElement(confirmPasswordField).sendKeys(newPassword);
        driver.findElement(saveButton).click();
    }
}
