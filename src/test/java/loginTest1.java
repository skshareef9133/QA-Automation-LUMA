import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTest1 {
    public static void main(String[] args){
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64(1)\\chromedriver-win64\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaebank.ccbp.tech/ebank/login");
        WebElement useridEl = driver.findElement(By.id("userIdInput"));
        useridEl.sendKeys("142420");
        System.out.println("User id entered");
        WebElement passwordEl = driver.findElement(By.id("pinInput"));
        passwordEl.sendKeys("231225");
        System.out.println("password entered");
        WebElement submitEl = driver.findElement(By.className("login-button"));
        submitEl.submit();
        System.out.println("submitted");
        //driver.quit();
        String Expetedurl = "https://qaebank.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(Expetedurl));
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(Expetedurl)) {
            System.out.println("Logged in successfully");
            System.out.println(driver.getTitle());
        }
        //driver.quit();
        WebElement logoutEl = driver.findElement(By.className("logout-button"));
        logoutEl.click();
        String expetedurl1 = "https://qaebank.ccbp.tech/ebank/login";
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait1.until(ExpectedConditions.urlToBe(expetedurl1));
        String currentUrl1 = driver.getCurrentUrl();
        if (currentUrl1.equals(expetedurl1)) {
            System.out.println("Logout successfully");
        }
        driver.quit();
    }
}
