package MoreWebDriverActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;


public class ScrollExamples {
    public static void main(String[] args){

        // Set the ChromeDriver location
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
        //C:\Users\Lenovo\Desktop\screenshot1.png
        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://the-internet.herokuapp.com/");

        // Maximize the browser window
        driver.manage().window().maximize();

        WebElement scroll = driver.findElement(By.xpath("//a[text()='Large & Deep DOM']"));
        scroll.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(800, 800)");
        //js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

        // Close the browser
        //driver.quit();

    }
}