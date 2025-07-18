import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cashwithdrawtest {
    public static void main(String[] args) {
        // Set path to the WebDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Cash Withdrawal app
            driver.get("https://qawithdrawal.ccbp.tech/");

            // Verify username
            WebElement usernameElement = driver.findElement(By.id("username"));
            String actualUsername = usernameElement.getText();
            String expectedUsername = "Sarah Williams";
            assert actualUsername.equals(expectedUsername) : "Username mismatch!";

            // Verify initial balance
            WebElement balanceElement = driver.findElement(By.id("balance"));
            int expectedBalance = 2000;
            int actualBalance = Integer.parseInt(balanceElement.getText());
            assert actualBalance == expectedBalance : "Initial balance incorrect!";

            // Locate and click all denomination buttons twice
            int[] denominations = {50, 100, 200, 500}; // example denominations
            for (int denomination : denominations) {
                WebElement button = driver.findElement(By.id("denom-" + denomination));
                for (int i = 0; i < 2; i++) {
                    button.click();
                    expectedBalance -= denomination;
                    balanceElement = driver.findElement(By.id("balance"));
                    actualBalance = Integer.parseInt(balanceElement.getText());
                    assert actualBalance == expectedBalance : "Balance mismatch after withdrawing " + denomination;
                }
            }

            System.out.println("All tests passed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
