import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class samplelogin {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaloginpage.ccbp.tech/");
        WebElement name = driver.findElement(By.id("username"));
        name.sendKeys("rahul");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("rahul@2023");
        WebElement btn1 = driver.findElement(By.className("login-button"));
        btn1.submit();
        String expectedurl = "https://qaloginpage.ccbp.tech/home";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlToBe(expectedurl));
        String currenturl = driver.getCurrentUrl();
        if (currenturl.equals(expectedurl)) {
            System.out.println("URL's matched");
            System.out.println(driver.getTitle());
        }
        driver.close();
    }
}
