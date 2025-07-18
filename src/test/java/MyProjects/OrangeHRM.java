package MyProjects;

import io.cucumber.java.cs.Ale;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHRM {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement usernameEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameEl.sendKeys("Admin");

        WebElement passwordEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordEl.sendKeys("admin123");

        WebElement loginbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        loginbtn.click();

        String Expectedurl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String Currenturl = driver.getCurrentUrl();
        if(Expectedurl.equals(Currenturl)){
            System.out.println("Login Successful");
        }
        else{
            System.out.println("Login Failed");
        }

        WebElement adminfld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='oxd-main-menu']/child::*[1]")));
        adminfld.click();

        //div[@class='oxd-table-cell-actions']/child::*[1]
        //span[@class='oxd-text oxd-text--span']
        WebElement FoundRecords = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span']")));
        //System.out.println(FoundRecords.getText());

        String text = FoundRecords.getText();

        // Use regex to extract the digits
        String numberOnly = text.replaceAll("[^0-9]", "");

        int result = Integer.parseInt(numberOnly); // Convert to integer
        System.out.println(result);


        for(int i = 0; i < result; i++) {
            WebElement deletebtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-table-cell-actions']/child::*[1]")));
            deletebtn.click();
            WebElement clickyes = driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin"));
            wait.until(ExpectedConditions.alertIsPresent());
            //WebDriver values = wait.until(ExpectedConditions.textToBe(By.className("oxd-text oxd-text--p oxd-text--card-title"),"Are you Sure?"));
            //Alert alertobj = driver.switchTo().alert();

            //div[@role='document']
            //WebDriver alert = driver.switchTo().frame("oxd-sheet oxd-sheet--rounded oxd-sheet--white oxd-dialog-sheet oxd-dialog-sheet--shadow oxd-dialog-sheet--gutters orangehrm-dialog-popup");
            //WebElement clickyes = driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin"));
            clickyes.click();
            //Alert alertobj = driver.switchTo().alert();
            //alertobj.accept();

        }

















    }
}
