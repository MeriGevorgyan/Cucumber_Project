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
    @When("user leaves username or password field empty")
    public void user_leaves_username_or_password_field_empty() {
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        usernameField.clear();
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.clear();
    }

    @Then("error message {string} or {string} appears")
    public void error_message_or_appears(String string, String string2) {
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualErrorMessage = errorMsg.getText();
    }

    @When("user enters invalid username or password")
    public void user_enters_invalid_username_or_password() {
        sendText("admin12345", loginPage.usernameField);
        sendText("12345", loginPage.passwordField);
    }

    @When("user enters a valid username and password")
    public void user_enters_a_valid_username_and_password() {
        sendText(ConfigReader.read("userName"),loginPage.usernameField);
        sendText(ConfigReader.read("password"),loginPage.passwordField);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginBtn);
    }



    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() {
        sendText(ConfigReader.read("userName"),loginPage.usernameField);
        sendText(ConfigReader.read("password"),loginPage.passwordField);
    }

    @Then("user is able to see dashboard page")
    public void user_is_able_to_see_dashboard_page() {
        WebElement dashboard = driver.findElement(By.id("menu_dashboard_index"));
        assertTrue(dashboard.isDisplayed());
    }

    @When("user clicks on PIM button")
    public void user_clicks_on_pim_button() {
        WebElement PIMopt = driver.findElement(By.id("menu_pim_viewPimModule"));
        click(PIMopt);
    }
    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployee= driver.findElement(By.id("menu_pim_addEmployee"));
        click(addEmployee);
    }

   @Then("user successfully logs in")
   public void user_successfully_logs_in() {
       WebElement dashboard = driver.findElement(By.id("menu_dashboard_index"));
       assertTrue(dashboard.isDisplayed());
   }

    @Then("error message {string} appears")
    public void errorMessageAppears(String error) {
        String errorValue = loginPage.errorMsg.getText();
        Assert.assertEquals("Invalid credentials", errorValue);
    }


}

