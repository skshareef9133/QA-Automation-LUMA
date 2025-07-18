package Base.pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AccountPage1 {
    WebDriver driver;

    By clickEle = By.className("customer-welcome");
    By signOutLink = By.xpath("//ul[@class='header links']/child::*[3]");

    public AccountPage1(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        driver.findElement(clickEle).click();
        driver.findElement(signOutLink).click();
    }
}
