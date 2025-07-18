package XpathOperators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class BooleanOperatorsExample {
    public static void main(String[] args) {
        // Set the path for chromedriver if needed
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to a website
        driver.get("https://qaxpathoperator.ccbp.tech/");

        // Boolean AND Operator: fetch a paragraph with class 'intro' and data-number attribute
        WebElement introParagraphText = driver.findElement(By.xpath("//p[@class='intro' and @data-number='5']"));

        System.out.println("Boolean AND Operator: " + introParagraphText.getText());

        // Boolean OR Operator: fetch a paragraph with class 'intro' or data-number as 10
        WebElement introParagraphText1 = driver.findElement(By.xpath("//p[@data-number='10']"));
        System.out.println("Boolean OR Operator: " + introParagraphText1.getText());

        // Boolean NOT Operator: fetch any element which does not have the 'hidden' attribute
        WebElement introParagraphText2 = driver.findElement(By.xpath("//p[@class='note']"));
        System.out.println("Boolean NOT Operator: " + introParagraphText2.getText());

        // Close the browser after task completion
        driver.quit();
    }
}