package MoreWebDriverActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args){


        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://qadraganddrop.ccbp.tech/");

        Actions actions = new Actions(driver);

        // Locate the source element (the element to be dragged)
        WebElement sourceElement = driver.findElement(By.cssSelector(".card:nth-child(1)"));

        // Locate the target element (the element where the source element will be dropped)
        WebElement targetElement = driver.findElement(By.cssSelector(".card:nth-child(2)"));

        // Perform the drag and drop action
        actions.dragAndDrop(sourceElement, targetElement).perform();

        // Get the text of the source card after the drag and drop action
        String sourceCardText = driver.findElement(By.cssSelector(".card:nth-child(1)")).getText();

        // Get the text of the target card after the drag and drop action
        String targetCardText = driver.findElement(By.cssSelector(".card:nth-child(2)")).getText();

        // Print the text of the cards
        System.out.println("Text of the source card after drag and drop: " + sourceCardText);
        System.out.println("Text of the target card after drag and drop: " + targetCardText);

        // Close the browser
        driver.quit();
    }
}