package Base.tests1;

import Base.BaseTest1;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.pages1.ChangePasswordPage1;
import Base.pages1.LoginPage1;
import Base.utils1.TestData1;

import java.time.Duration;

public class ChangePasswordTest1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    @Test
    public void changeUserPassword() {
        LoginPage1 loginPage = new LoginPage1(driver);
        loginPage.login(TestData1.TEST_EMAIL, TestData1.OLD_PASSWORD);

        ChangePasswordPage1 changePasswordPage = new ChangePasswordPage1(driver);
        changePasswordPage.changePassword(TestData1.OLD_PASSWORD, TestData1.NEW_PASSWORD);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

//        LoginPage1 login = new LoginPage1(driver);
//        login.open();
//        login.login(signupTest1.testEmail, signupTest1.password);
//
//
//        ChangePasswordPage1 change = new ChangePasswordPage1(driver);
//        change.open();
//        String newPassword = "NewPass@#*3";
//        change.changePassword1(TestData1.password, newPassword);
//
//        System.out.println("Password Changed successfully");
//
//        // Optionally update password variable for further use
//        TestData1.password = newPassword;

//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        driver.get("https://magento.softwaretestingboard.com/customer/account/index/");
//        //https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/
//        WebElement emailEle = driver.findElement(By.id("email"));
//        emailEle.sendKeys("shareef5@gmail.com");
//        WebElement passwordEle = driver.findElement(By.id("pass"));
//        passwordEle.sendKeys("NewPass@#*4");
//        WebElement signBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("send2")));
//        signBtn.click();
//
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("window.scrollTo(0,400)");
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='box-actions']/child::*[2]")));
//        WebElement changepasswordBtn = driver.findElement(By.xpath("//div[@class='box-actions']/child::*[2]"));
//        changepasswordBtn.click();
//
//        js.executeScript("window.scrollTo(0,500)");
//
//        WebElement currentpassEle = driver.findElement(By.id("current-password"));
//        currentpassEle.sendKeys("NewPass@#*4");
//        WebElement newpasswordEle = driver.findElement(By.id("password"));
//        newpasswordEle.sendKeys("NewPass@#*5");
//        WebElement conformpassEle = driver.findElement(By.id("password-confirmation"));
//        conformpassEle.sendKeys("NewPass@#*5");
//        WebElement saveBtn = driver.findElement(By.xpath("//button[@title='Save']"));
//        saveBtn.click();

