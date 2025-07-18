package Base.tests1;

import Base.BaseTest1;
import Luma_Assessment.classpages.SignupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.pages1.signupPage1;
import Base.utils1.TestData1;

import java.time.Duration;

public class signupTest1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    @Test
    public void createNewAccount() {
        String dynamicEmail = "user" + System.currentTimeMillis() + "@gmail.com";
        signupPage1 signupPage = new signupPage1(driver);
        signupPage.signUp(TestData1.FIRST_NAME, TestData1.LAST_NAME, dynamicEmail, TestData1.OLD_PASSWORD);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
