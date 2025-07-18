import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class WikipediaSearchTest {

    public static void main(String[] args) {

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Launch Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the Wiki Search page
        driver.get("https://qawikisearch.ccbp.tech/");

        // Enter search text in the input field
        WebElement searchField = driver.findElement(By.xpath("//input[@id = 'searchInput']"));
        searchField.sendKeys("HTML");

        // Click the 'Search' button
        WebElement searchButton = driver.findElement(By.xpath("//button[@class = 'search-button']"));
        searchButton.click();

        // Wait until the songs list is loaded.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='result-item']")));

        // Find all the search results
        List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class='result-item']"));
        System.out.println(searchResult.size() + " Results Found");

        // Quit the WebDriver instance
        driver.quit();

    }
}