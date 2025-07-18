package Luma_Assessment.classpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By createAccountLink = By.linkText("Create an Account");

    public void clickCreateAccount() {
        driver.findElement(createAccountLink).click();
    }
}
