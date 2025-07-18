package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageUsingPageFactory {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPageUsingPageFactory(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(how = How.ID, using = "username")
    WebElement usernameEle;

    @FindBy(how = How.ID, using = "password")
    WebElement passwordEle;

    @FindBy(how = How.CLASS_NAME, using = "login-button")
    WebElement loginbuttonEle;

    @FindBy(how = How.CLASS_NAME, using="error-message")
    WebElement errorMessageEle;


    public void enterUsername(String username) {
        usernameEle.sendKeys(username);
    }
    public void enterPassword(String password) {
        passwordEle.sendKeys(password);
    }
    public void clickLoginButton() {
        loginbuttonEle.click();
    }
    public void loginToApplication(String username, String password){
        usernameEle.sendKeys(username);
        passwordEle.sendKeys(password);
        loginbuttonEle.click();
    }
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return errorMessageEle.getText();
    }

}
