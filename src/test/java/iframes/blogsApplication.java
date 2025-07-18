package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class blogsApplication {
    public static void main(String args[]) {

            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");

            // Launch the Chrome browser
            WebDriver driver = new ChromeDriver();

            // Navigate to the NxtApps Application
            driver.get("https://qanxtapps.ccbp.tech/");

            WebElement headingEle = driver.findElement(By.id("app-heading"));

            String expectedHeading = "My Applications";
            String actualHeading = headingEle.getText();
            if(expectedHeading.equals(actualHeading)){
                System.out.println("Acutal Heading Matched with the Expected Heading");
            }
            else {
                System.out.println("Acutal Heading is not Matched with the Expected Heading");
            }

            WebElement blogHubEle = driver.findElement(By.xpath("//div[@class='cards']/child::*[2]"));
            blogHubEle.click();

            driver.switchTo().frame("//iframe[@id='appFrameCard']");

            WebElement aboutLink = driver.findElement(By.xpath("//a[text()='About']"));
            aboutLink.click();


    }
}