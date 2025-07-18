import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TipcalpageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://qatipcalc.ccbp.tech/");

        // Test Tip Calculation
        WebElement billInput = driver.findElement(By.cssSelector("input[id='billAmount']"));
        billInput.sendKeys("1000");

        WebElement percentageInput = driver.findElement(By.cssSelector("input[id='percentageTip']"));
        percentageInput.sendKeys("12");

        WebElement calculateBtn = driver.findElement(By.cssSelector("button[id='calculateButton']"));
        calculateBtn.click();

        WebElement tipAmount = driver.findElement(By.cssSelector("p[id='tipAmount']"));
        WebElement totalAmount = driver.findElement(By.cssSelector("p[id='totalAmount']"));

        if (tipAmount.getText().equals("120.00") && totalAmount.getText().equals("1120.00")) {
            System.out.println("Tip Calculated Correctly");
        } else {
            System.out.println("Tip Calculated Incorrectly");
        }

        // Test error for no input
        percentageInput.clear();
        calculateBtn.click();

        WebElement errorMsg = driver.findElement(By.cssSelector("p[class*='error']"));
        if (errorMsg.isDisplayed() && errorMsg.getText().equals("Please Enter a Valid Input.")) {
            System.out.println("Error message displayed for no input");
        } else {
            System.out.println("Error message missing for no input");
        }

        // Test error for invalid input
        percentageInput.sendKeys("10f");
        calculateBtn.click();

        WebElement errorMsg2 = driver.findElement(By.cssSelector("p[id='errorMessage']"));
        if (errorMsg2.isDisplayed() && errorMsg2.getText().equals("Please Enter a Valid Input.")) {
            System.out.println("Error message displayed for invalid input");
        } else {
            System.out.println("Error message missing for invalid input");
        }

        // Close the browser
        driver.quit();
    }
}
