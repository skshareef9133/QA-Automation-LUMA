package MyProjects;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Theinternet {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Lenovo\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

          //_______________Add and remove elements_______________

          WebElement addelement = driver.findElement(By.xpath("//a[text()='Add/Remove Elements']"));
          addelement.click();

          WebElement headaddremove = driver.findElement(By.xpath("//h3"));
          System.out.println(headaddremove.getText());
          WebElement clickbtn = driver.findElement(By.xpath("//button"));
          int a = 3;
          for (int b=0 ; b<a; b=b+1){
              clickbtn.click();
          }
          int x = 3;
          for (int y=0 ; y<x; y=y+1) {
              WebElement deletebtn = driver.findElement(By.xpath("//button[text()='Delete']"));
              deletebtn.click();
          }
          driver.navigate().back();
          System.out.println("---------------");

          //_______________Challenging DOM_______________

          WebElement dom = driver.findElement(By.xpath("//a[text()='Challenging DOM']"));
          dom.click();

          WebElement headdom = driver.findElement(By.xpath("//h3"));
          System.out.println(headdom.getText());

          WebElement btn1 = driver.findElement(By.xpath("//a[@class='button']"));
          System.out.println("Before clicking: " + btn1.getText());
          btn1.click();
          WebElement btn11 = driver.findElement(By.xpath("//a[@class='button']"));
          System.out.println("After clicking: " + btn11.getText());

          WebElement btn2 = driver.findElement(By.xpath("//a[@class='button alert']"));
          System.out.println("Before clicking: " + btn2.getText());
          btn2.click();
          WebElement btn22 = driver.findElement(By.xpath("//a[@class='button alert']"));
          System.out.println("After clicking: " + btn22.getText());

          WebElement btn3 = driver.findElement(By.xpath("//a[@class='button success']"));
          System.out.println("Before clicking: " + btn3.getText());
          btn3.click();
          WebElement btn33 = driver.findElement(By.xpath("//a[@class='button success']"));
          System.out.println("After clicking: " + btn33.getText());

          driver.navigate().back();
          System.out.println("---------------");

          //_______________Checkboxes________________

          WebElement checkbox = driver.findElement(By.xpath("//a[text()='Checkboxes']"));
          checkbox.click();

          WebElement headchechbox = driver.findElement(By.xpath("//h3"));
          System.out.println(headchechbox.getText());

          WebElement box1 = driver.findElement(By.xpath("//div[@class='example']/descendant::*[3]"));
          box1.click();

          WebElement box2 = driver.findElement(By.xpath("//div[@class='example']/descendant::*[5]"));
          box2.click();

          driver.navigate().back();
          System.out.println("---------------");

          //_______________context menu________________

          WebElement context = driver.findElement(By.xpath("//a[text()='Context Menu']"));
          context.click();

          WebElement headcontext = driver.findElement(By.xpath("//h3"));
          System.out.println(headcontext.getText());

          WebElement rightclick = driver.findElement(By.id("hot-spot"));
          Actions actions = new Actions(driver) ;
          actions.contextClick(rightclick).perform();

          Alert alertobj = driver.switchTo().alert();
          alertobj.accept();

          driver.navigate().refresh();
          driver.navigate().back();
          System.out.println("---------------");

          //_______________Disappearing Elements_______________

          WebElement disappearing = driver.findElement(By.xpath("//a[text()='Disappearing Elements']"));
          disappearing.click();

          WebElement headdisappear = driver.findElement(By.xpath("//h3"));
          System.out.println(headdisappear.getText());

          WebElement aboutEl = driver.findElement(By.xpath("//a[text()='About']"));
          aboutEl.click();
          WebElement text1 = driver.findElement(By.xpath("//h1"));
          System.out.println("About: " + text1.getText());

          driver.navigate().back();

          WebElement contactUsEl = driver.findElement(By.xpath("//a[text()='Contact Us']"));
          contactUsEl.click();

          WebElement text2 = driver.findElement(By.xpath("//h1"));
          System.out.println("Contact Us: " + text2.getText());

          driver.navigate().back();

          WebElement portfolioEl = driver.findElement(By.xpath("//a[text()='Portfolio']"));
          portfolioEl.click();
          WebElement text3 = driver.findElement(By.xpath("//h1"));
          System.out.println("Portfolio: " + text3.getText());

          driver.navigate().back();

          //Gallery Element(Disappearing Elements)
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
          driver.navigate().refresh();

          try {
              // Wait until the element is visible
              WebElement element = wait.until(
                      ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Gallery']")));
                      System.out.println(element.getText() + " :Element appeared");

          } catch (Exception e) {
              System.out.println("Gallery Element did not appear.");
          }

          WebElement homeEle = driver.findElement(By.xpath("//a[text()='Home']"));
          homeEle.click();
          System.out.println("---------------");

          //_______________Drag And Drop_______________

          WebElement dragAnddropEle = driver.findElement(By.xpath("//a[text()='Drag and Drop']"));
          dragAnddropEle.click();

          WebElement Ele_A = driver.findElement(By.id("column-a"));
          WebElement Ele_B = driver.findElement(By.id("column-b"));

          System.out.println("Before Action: " + Ele_A.getText());

          actions.dragAndDrop(Ele_A,Ele_B).perform();

          System.out.println("After Action: " + Ele_A.getText());
          driver.navigate().back();

          System.out.println("---------------");

          //____________________DropDown____________________

          WebElement dropdownEle = driver.findElement(By.xpath("//a[text()='Dropdown']"));
          dropdownEle.click();

          WebElement listEle = driver.findElement(By.id("dropdown"));
          Select optionSelect = new Select((listEle));
          System.out.println(listEle.getText());
          optionSelect.selectByVisibleText("Option 2");
          System.out.println("I'm Selecting option 2");

          driver.navigate().back();
          System.out.println("---------------");

          //_________________Dynamically Loaded Page Elements________________

          WebElement loadpageEle = driver.findElement(By.xpath("//a[text()='Dynamic Loading']"));
          loadpageEle.click();

          WebElement clickexample1 = driver.findElement(By.cssSelector("div.example>:nth-child(5)"));
          clickexample1.click();

          WebElement clickstartBtn1 = driver.findElement(By.xpath("//button"));
          clickstartBtn1.click();

          WebElement msg1 = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
          System.out.println("Example 1: " + msg1.getText());

          driver.navigate().back();

          WebElement clickexample2 = driver.findElement(By.cssSelector("div.example>:nth-child(8)"));
          clickexample2.click();

          WebElement clickstartBtn2 = driver.findElement(By.xpath("//div[@id='start']/child::*"));
          clickstartBtn2.click();

          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/child::*")));
          System.out.println("Example 2: Hello World!");

          driver.navigate().back();
          driver.navigate().back();
          System.out.println("---------------");

          //_______________Floating Menu_______________

          WebElement floatingEle = driver.findElement(By.xpath("//a[text()='Floating Menu']"));
          floatingEle.click();

          //Scroll Action

          JavascriptExecutor js = (JavascriptExecutor)driver;
          js.executeScript("window.scrollTo(0,2000);");
          //js.executeScript("window.scrollTo(0,document.body.scrollHeight);");

          driver.navigate().back();
          System.out.println("Horizontal scroll");
          System.out.println("---------------");

//          //_________________Form Authentication_______________
//
//          WebElement formEle = driver.findElement(By.xpath("//a[text()='Form Authentication']"));
//          formEle.click();
//
//          WebElement usernameEle = driver.findElement(By.id("username"));
//          usernameEle.sendKeys("tomsmith");
//
//          WebElement passwordEle = driver.findElement(By.id("password"));
//          passwordEle.sendKeys("SuperSecretPassword!");
//
//          WebElement loginBtn = driver.findElement(By.xpath("//i[text()=' Login']"));
//          loginBtn.click();
//
//          wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
//
//          WebElement loginMsg = driver.findElement(By.id("flash"));
//          System.out.println(loginMsg.getText());
//
//          WebElement logoutBtn = driver.findElement(By.xpath("//i[text()=' Logout']"));
//          logoutBtn.click();
//
//          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[text()=' Logout']")));
//          driver.navigate().back();
//          driver.navigate().back();
//          System.out.println("---------------");



        //________________Geolocation_______________

        WebElement locationEle = driver.findElement(By.xpath("//a[text()='Geolocation']"));
        locationEle.click();

        WebElement whereiamBtn = driver.findElement(By.tagName("button"));
        whereiamBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='demo']/child::*[1]")));

        WebElement latitude = driver.findElement(By.xpath("//p[@id='demo']/child::*[1]"));
        System.out.println("Latitude: " + latitude.getText());

        WebElement longitude = driver.findElement(By.xpath("//p[@id='demo']/child::*[3]"));
        System.out.println("Longitude: " + longitude.getText());

        driver.navigate().back();
        System.out.println("---------------");
        driver.quit();

//        //_______________Horizontal Slider___________________
//
//        WebElement horizontalslideEle = driver.findElement(By.xpath("//a[text()='Horizontal Slider']"));
//        horizontalslideEle.click();

    }
}
