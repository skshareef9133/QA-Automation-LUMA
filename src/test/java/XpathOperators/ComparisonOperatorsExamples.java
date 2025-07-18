package XpathOperators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class ComparisonOperatorsExamples {
    public static void main(String[] args) {
        // Set the path for chromedriver if needed
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Navigate to a website
        driver.get("https://qaxpathoperator.ccbp.tech/");

        // Equals To Operator
        String equalsToText = driver.findElement(By.xpath("//p[@data-number='10']")).getText();
        System.out.println("Equals To Operator: " + equalsToText);

        // Not Equals To Operator
        String notEqualsToText = driver.findElement(By.xpath("//p[@data-number!='10']")).getText();
        System.out.println("Not Equals To Operator: " + notEqualsToText);

        // Less Than Operator
        String lessThanText = driver.findElement(By.xpath("//p[@data-number<'10']")).getText();
        System.out.println("Less Than Operator: " + lessThanText);

        // Greater Than Operator
        String greaterThanText = driver.findElement(By.xpath("//p[@data-number>'5']")).getText();
        System.out.println("Greater Than Operator: " + greaterThanText);

        // Less Than or Equals To Operator
        String lessThanOrEqualsToText = driver.findElement(By.xpath("//p[@data-number<='10']")).getText();
        System.out.println("Less Than or Equals To Operator: " + lessThanOrEqualsToText);

        // Greater Than or Equals To Operator
        String greaterThanOrEqualsToText = driver.findElement(By.xpath("//p[@data-number>='10']")).getText();
        System.out.println("Greater Than or Equals To Operator: " + greaterThanOrEqualsToText);

        // Close the browser after task completion
        driver.close();
    }
}
