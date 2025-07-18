package MoreWebDriverActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class MouseHoverAction {
    public static void main(String[] args){

        // Set the ChromeDriver location
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://qadraganddrop.ccbp.tech/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Locate the elements with class name "card"
        List<WebElement> cardElements = driver.findElements(By.className("card"));

        // Create an Actions object to perform hover actions
        Actions action = new Actions(driver);

        // Iterate over the card elements, perform a hover action, and print the text color of each card before and after the hover action
        for (WebElement cardElement : cardElements) {
            // Get the original text color
            String originalColor = cardElement.getCssValue("color");
            System.out.println("Original text color: " + originalColor);

            // Perform the hover action on the card
            action.moveToElement(cardElement).perform();


            // Get the new text color
            String newColor = cardElement.getCssValue("color");
            System.out.println("Text color after hover: " + newColor);

            // Print an empty line for better readability
            System.out.println();
        }

        // Close the browser
        driver.quit();
    }
}