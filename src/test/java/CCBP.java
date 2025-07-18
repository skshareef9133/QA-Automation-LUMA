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

import org.testng.Assert;
import org.testng.annotations.Listeners;

@Listeners(nxtTrendz.class)
public class CCBP {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        ///home/nxtwavetechhari/Downloads/chromedriver_linux64/chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chrome-win64\\chrome-win64.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulnxttrendz.ccbp.tech/login");

        WebElement usernameEl = driver.findElement(By.id("username"));
        usernameEl.sendKeys("rahul");

        WebElement passwordEl = driver.findElement(By.id("password"));
        passwordEl.sendKeys("rahul@2021");

        WebElement loginButtonEl = driver.findElement(By.className("login-button"));
        loginButtonEl.submit();

    }

    @Test
    public void clickOnShopNowButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shopNowEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shop-now-button")));
        shopNowEl.click();

        String expectedUrl = "https://rahulnxttrendz.ccbp.tech/products";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");

    }

    @Test
    public void checkHeadingElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-heading")));

        Assert.assertTrue(element.isDisplayed(), "Element is not visible");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}