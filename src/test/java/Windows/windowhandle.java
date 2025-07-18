package Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class windowhandle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://qahndlwindows.ccbp.tech/");

        String parentWindowHandle = driver.getWindowHandle();

        // Click on the "Open New Window" button
        WebElement newWindowBtn = driver.findElement(By.id("newTab"));
        newWindowBtn.click();

        // get all window handles
        Set<String> windowHandlesSet = driver.getWindowHandles();

        for(String windowHandle : windowHandlesSet) {
            if(!(windowHandle.equals(parentWindowHandle))) {
                // switching to new window
                driver.switchTo().window(windowHandle);

                //WebElement type = driver.findElement(By.id("APjFqb"));
                //type.sendKeys("abc");

                String title = driver.getTitle();
                System.out.println(title);
            }
        }
        driver.quit();

    }
}