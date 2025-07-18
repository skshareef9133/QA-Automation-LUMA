package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import pages.LoginPage;


public class LoginPageTest {

    WebDriver driver;
    //LoginPage loginmodel;
    LoginPageUsingPageFactory loginPageUsingPageFactory;

    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
                { "praneetha", "praneetha@2021" },
                { "rahul", "rahul@2021" }

        };
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulnxttrendz.ccbp.tech/login");
        loginPageUsingPageFactory = new LoginPageUsingPageFactory(driver);
    }


    @Test(priority = 1, dataProvider = "loginData")
    public void loginWithValidCredentials(String username, String password) {

        loginPageUsingPageFactory.loginToApplication(username, password);

        String expectedUrl = "https://rahulnxttrendz.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
    }

    @Test(priority = 2)
    public void loginWithInvalidCredentials() {

        loginPageUsingPageFactory.loginToApplication("rahul", "rashul@2021");

        // Get error message text
        String errorMessage = loginPageUsingPageFactory.getErrorMessage();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}