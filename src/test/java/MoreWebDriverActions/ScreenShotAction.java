package MoreWebDriverActions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotAction {
    public static void main(String[] args) throws IOException {

        // Set the ChromeDriver location
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://qadraganddrop.ccbp.tech/");

        // Maximize the browser window
        driver.manage().window().maximize();

        TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
        File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("C:\\Users\\Lenovo\\Downloads\\screenshot1.png"));

        //try {
        //    FileUtils.copyFile(screenshot, new File("C:\\Users\\Lenovo\\Downloads\\screenshot1.png"));
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

        driver.quit();

    }
}