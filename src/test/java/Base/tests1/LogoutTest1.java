package Base.tests1;

import Base.BaseTest1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.pages1.AccountPage1;
import Base.pages1.LoginPage1;
import Base.utils1.TestData1;

public class LogoutTest1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    @Test
    public void logoutAfterLogin() {
        LoginPage1 loginPage = new LoginPage1(driver);
        loginPage.login(TestData1.TEST_EMAIL, TestData1.NEW_PASSWORD);

        AccountPage1 accountPage = new AccountPage1(driver);
        accountPage.logout();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

