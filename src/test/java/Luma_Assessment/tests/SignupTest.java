package Luma_Assessment.tests;

import Luma_Assessment.classpages.SignupPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class SignupTest {
    public WebDriver driver;
    public WebDriverWait wait;

        @BeforeMethod
        public void setup() {
            //System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://magento.softwaretestingboard.com/");
            driver.manage().window().maximize();
        }



       @Test
        public void testSignup() {
           wait = new WebDriverWait(driver,Duration.ofSeconds(10));
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Create an Account']"))).click();
           //WebElement createAccEle = driver.findElement(By.xpath("//a[text()='Create an Account']"));
           //createAccEle.click();
           wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/customer/account/create/"));
           WebElement firstnameEl = driver.findElement(By.id("firstname"));
           firstnameEl.sendKeys("shareef");
           WebElement lastnameEl = driver.findElement(By.id("lastname"));
           lastnameEl.sendKeys("sk");
           WebElement emailEl = driver.findElement(By.id("email_address"));
           emailEl.sendKeys("skshareef9133@gmail.com");
           WebElement passwordEl = driver.findElement(By.id("password"));
           passwordEl.sendKeys("Sk9133@#*");
           WebElement conformpasswordEl = driver.findElement(By.id("password-confirmation"));
           conformpasswordEl.sendKeys("Sk9133@#*");
           WebElement createBtn = driver.findElement(By.xpath("//span[text()='Create an Account']"));
           createBtn.click();
       }


        @AfterMethod
        public void tearDown () {
            driver.quit();
        }
    }