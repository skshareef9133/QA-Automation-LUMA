package Base.pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage1 {
    WebDriver driver;
    WebDriverWait wait;

    By emailField = By.id("email");
    By passwordField = By.id("pass");
    By signInButton = By.id("send2");

    public LoginPage1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String email, String password) {
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }
}
