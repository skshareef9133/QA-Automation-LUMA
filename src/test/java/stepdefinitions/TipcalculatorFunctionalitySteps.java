package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class TipcalculatorFunctionalitySteps {
    WebDriver driver = Hooks.getDriver();


    @Given("I navigate to the tip calculator page")
    public void navigate_to_tip_calculator_page() {
        driver = new ChromeDriver();
        driver.get("https://qatipcalc.ccbp.tech/");
    }

    @When("I enter {string} as the bill amount")
    public void enter_bill_amount(String amount) {
        WebElement billAmountInput = driver.findElement(By.cssSelector("input[id='billAmount']"));
        billAmountInput.sendKeys(amount);
    }

    @When("I enter {string} as the tip percentage")
    public void enter_tip_percentage(String percentage) {
        WebElement tipPercentageInput = driver.findElement(By.cssSelector("input[id='percentageTip']"));
        tipPercentageInput.sendKeys(percentage);
    }

    @When("I click the calculate button")
    public void click_calculate_button() {
        WebElement calculateButton = driver.findElement(By.cssSelector("button[id='calculateButton']"));
        calculateButton.click();
    }

    @Then("I should see the tip amount as {string}")
    public void verify_tip_amount(String expectedTip) {
        WebElement tipAmount = driver.findElement(By.cssSelector("p[id='tipAmount']"));
        assertEquals(expectedTip, tipAmount.getText());
    }

    @Then("I should see the total amount as {string}")
    public void verify_total_amount(String expectedTotal) {
        WebElement totalAmount = driver.findElement(By.cssSelector("p[id='totalAmount']"));
        assertEquals(expectedTotal, totalAmount.getText());
        driver.close();
    }

}