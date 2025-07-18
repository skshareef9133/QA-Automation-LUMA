package stepdefinitions;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import io.cucumber.java.After;
public class LoginFunctionalitySteps {
    WebDriver driver = Hooks.getDriver();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.get("https://rahulnxttrendz.ccbp.tech/login");
    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        driver.findElement(By.id("username")).sendKeys("rahul");
        driver.findElement(By.id("password")).sendKeys("rahul@2021");
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        driver.findElement(By.className("login-button")).click();
    }

    @Then("I should be redirected to the home page")
    public void iShouldBeRedirectedToTheHomePage() {
        String expectedUrl = "https://rahulnxttrendz.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
    }

    //@AfterAll
    //public static void after_all_tests() throws IOException {
    //    File htmlFile = new File("target/HtmlReport.html");
    //    Desktop.getDesktop().browse(htmlFile.toURI());
    //}
}