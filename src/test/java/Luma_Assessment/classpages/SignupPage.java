package Luma_Assessment.classpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class SignupPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SignupPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By createAccountLink = By.linkText("Create an Account");
    By firstName = By.id("firstname");
    By lastName = By.id("lastname");
    By email = By.id("email_address");
    By password = By.id("password");
    By confirmPassword = By.id("password-confirmation");
    By createAccountBtn = By.cssSelector("button[title='Create an Account']");
    By welcomeMessage = By.cssSelector(".page-title span");

    // Actions
    public void clickCreateAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountLink)).click();
    }

    public void enterFirstName(String fname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void confirmPassword(String pass) {
        driver.findElement(confirmPassword).sendKeys(pass);
    }

    public void clickCreateAccountBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();
    }

    public String getWelcomeMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage)).getText();
    }
}