package Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class MultipleWindows {
    public static void switchWindowByTitle(String title, WebDriver driver) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle: handles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://qahndlwindows.ccbp.tech/");

        // Click on the "Open New Window" button
        WebElement newWindowBtn = driver.findElement(By.id("newWindow"));
        newWindowBtn.click();

        // Click on the "Open New Flipkart Window" button
        WebElement newFlipkatWindowBtn = driver.findElement(By.id("newFlipkartWindow"));
        newFlipkatWindowBtn.click();

        // Switch to the Google page using the title of the page
        switchWindowByTitle("Google", driver);
        System.out.println(driver.getCurrentUrl());

        //WebElement type = driver.findElement(By.id("APjFqb"));
        //type.sendKeys("Mobiles");

        // Switch to the Flipkart page using the title of the page
        switchWindowByTitle("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", driver);
        System.out.println(driver.getCurrentUrl());

        //WebElement search = driver.findElement(By.className("Pke_EE"));
        //search.sendKeys("Mobiles");


        driver.quit();
    }
}
