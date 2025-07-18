import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
    public class loginTest2 {
       public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://qaloginpage.ccbp.tech/");
//        WebElement usernameEl = driver.findElement(By.id("username"));
//        usernameEl.sendKeys("rahul");
//        System.out.println("username entered");
//        WebElement passwordEl = driver.findElement(By.id("password"));
//        passwordEl.sendKeys("rahul@2023");
//        System.out.println("password entered");
//        WebElement buttonEl = driver.findElement(By.className("login-button"));
//        buttonEl.submit();
//        System.out.println("login button clicked");
//        String expectedUrl = "https://qaloginpage.ccbp.tech/home";
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlToBe(expectedUrl));
//        String currenturl = driver.getCurrentUrl();
//        System.out.println(currenturl);
//        if(currenturl.equals(expectedUrl)){
//            System.out.println("Login successfully");
//            System.out.println(driver.getTitle());
//
//        }
//        driver.quit();


//    public class RegistrationTest{
//        public static void main(String[] args){


          try {
             System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
             // Open the Chrome Browser
             WebDriver driver = new ChromeDriver();

             // Open the NxtTrendz login page
             driver.get("https://rahulnxttrendz.ccbp.tech/login");

             // Find and fill in the form fields
             WebElement usernameEl = driver.findElement(By.xpath("//input[@id='username']"));
             usernameEl.sendKeys("rahul");
             WebElement passwordEl = driver.findElement(By.xpath("//input[@id='password']"));
             passwordEl.sendKeys("rahul@2021");

             WebElement buttonEl = driver.findElement(By.xpath("//button[@type='submit']"));
             buttonEl.submit();

             // Define the expected URL of the home page
             String homePageUrl = "https://rahulnxttrendz.ccbp.tech/";

             // Wait for the expected URL to be loaded
             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
             wait.until(ExpectedConditions.urlToBe(homePageUrl));

             // Get the current URL after login
             String currentUrl1 = driver.getCurrentUrl();

             if (currentUrl1.equals(homePageUrl)) {
                System.out.println("Navigation to home page was successful!");
             } else {
                System.out.println("Navigation to home page failed!");
             }

             // Find and click on the "Shop Now" button
             WebElement shopNowButtonEl =
                     driver.findElement(By.xpath("//button[@class='shop-now-button']"));
             shopNowButtonEl.click();

             // Define the expected URL of the products page
             String productsPageUrl = "https://rahulnxttrendz.ccbp.tech/products";

             // Get the current URL after navigation to products page
             currentUrl1 = driver.getCurrentUrl();

             if (currentUrl1.equals(productsPageUrl)) {
                System.out.println("Navigation to products page was successful!");
             }

             //Wait until elements are displayed
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='product-item']")));

             // Verify the display of products on the products page
             List<WebElement> products = driver.findElements(By.xpath("//li[@class='product-item']"));

             if (products.size() > 0) {
                System.out.println("Products are displayed successfully on the products page: " + products.size());

                // Select Product with text Minifigures
                WebElement productNameEle = driver.findElement(By.xpath("//h1[text()='Minifigures']"));
                String expectedProductTitle = productNameEle.getText();
                System.out.println(expectedProductTitle);

                productNameEle.click();

                String productDetailsUrl = "https://rahulnxttrendz.ccbp.tech/products/1002";
                wait.until(ExpectedConditions.urlToBe(productDetailsUrl));

                String currentUrl = driver.getCurrentUrl();
                if (currentUrl.equals(productDetailsUrl)) {
                   System.out.println("Navigation to product details page is successful!");
                }

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pro-details-success-view']")));
                WebElement productTitleElement = driver.findElement(By.xpath("//h1[contains(text(),'Minifig')]"));
                String actualProductTitle = productTitleElement.getText();
                if (expectedProductTitle.equals(actualProductTitle)) {
                   System.out.println("Product Name is - " + actualProductTitle);
                } else {
                   System.out.println("Actual product name is not same as expected product name" + actualProductTitle);
                }

                String expectedDesc = "Collect all mystery mini-figures in the new series 11 and grow your LEGO Minifigure Collection. Each mini-figure comes in a sealed “mystery” bag with its accessories, display plate, and collector’s booklet. Only 1 of 16 individual mini-figures will be available in each “mystery” bag.";
                String actualProductDesc = "success";
                if (expectedDesc.equals(actualProductDesc)) {
                   System.out.println("Description is - " + actualProductDesc);
                } else {
                   System.out.println("Actual description is not same as expected description" + actualProductDesc);
                }

             } else {
                System.out.println("No products found on the products page.");
             }

             // Close the browser
             driver.quit();
          } catch (Exception e) {
             System.out.println("An exception occurred: " + e.getMessage());
          }
       }
    }





