package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class loginSteps extends CommonMethods {

    @When("user leaves username field empty")
    public void user_leaves_username_field_empty() {
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        usernameField.clear();
    }

    @When("user enters a valid password")
    public void user_enters_a_valid_password() {
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginBtn);
    }

    @Then("error message {string} appears")
    public void error_message_appears(String errorMessage) {
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualErrorMessage = errorMsg.getText();

    }

   @When("user enters the valid username")
   public void user_enters_the_valid_username() {
       sendText(ConfigReader.read("userName"),loginPage.usernameField);
   }
   @When("user leaves password field empty")
   public void user_leaves_password_field_empty() {
       WebElement passwordField = driver.findElement(By.id("txtPassword"));
       passwordField.clear();
   }

   @When("user enters invalid username")
   public void user_enters_invalid_username() {
       WebElement usernameField = driver.findElement(By.id("txtUsername"));
       usernameField.sendKeys("admin1256");
   }

   @Then("user successfully logs in")
   public void user_successfully_logs_in() {
       WebElement dashboard = driver.findElement(By.id("menu_dashboard_index"));
       assertTrue(dashboard.isDisplayed());
   }

   @When("user enters a valid username")
   public void userEntersAValidUsername() {
       sendText(ConfigReader.read("userName"),loginPage.usernameField);
   }

}

