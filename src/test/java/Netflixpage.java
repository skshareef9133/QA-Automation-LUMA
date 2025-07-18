import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Netflixpage {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.snapchat.com");
        String title1 = driver.getTitle();
        System.out.println("Title: " + title1);
        String title2 = driver.getCurrentUrl();
        System.out.println("Currenturl: " + title2);
        driver.quit();
    }
}
