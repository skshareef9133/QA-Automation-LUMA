package BrowserCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExamples {

    public static void main(String[] args) {

        // Set the path to the chromedriver executable
        // Note: Replace '/path/to/chromedriver' with the actual path on Web system
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        //Dimension newDimension = new Dimension(524, 568);
        //driver.manage().window().setSize(newDimension);

        // Navigate to another URL using the navigate().to() method
        driver.navigate().to("https://rahulnxttrendz.ccbp.tech/login");

        WebElement buttonEl = driver.findElement(By.className("login-button"));

        boolean isDisplayed = buttonEl.isDisplayed();

        System.out.println(isDisplayed);

        // Close the browser after tasks are completed
        driver.quit();
    }
}