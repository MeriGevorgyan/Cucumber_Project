package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddEmployeePage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class addEmployeeSteps extends CommonMethods {


    @Given("user enters admin username and password")
    public void user_enters_admin_username_and_password() {
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        sendText(ConfigReader.read("userName"), usernameField);
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        sendText(ConfigReader.read("password"),passwordField);
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
    @When("user provides the first name {string}")
    public void user_provides_the_first_name(String firstname) {
        //firstNameLocator.sendKeys(firstname);
        sendText(firstname,addEmployeePage.firstNameLocator);
    }
    @When("user provides the last name {string}")
    public void user_provides_the_last_name(String lastname) {
        sendText(lastname,addEmployeePage.lastNameLocator);
    }
    @When("user leaves employee ID field empty")
    public void user_leaves_employee_id_field_empty() {
        WebElement employeeIDLocator= driver.findElement(By.id("employeeId"));
        employeeIDLocator.clear();
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveButton= driver.findElement(By.id("btnSave"));
        click(saveButton);
    }

    @Then("employee's details should be saved")
    public void employee_s_details_should_be_saved() {
        WebElement employeeList= driver.findElement(By.id("menu_pim_viewEmployeeList"));
        assertTrue(employeeList.isDisplayed());
    }

    @When("user enters first name {string}")
    public void user_enters_first_name(String firstname1) {
        WebElement firstNameLocator1= driver.findElement(By.id("firstName"));
        firstNameLocator1.sendKeys(firstname1);
    }
    @When("user enters last name {string}")
    public void user_enters_last_name(String lastname1) {
        WebElement lastNameLocator1= driver.findElement(By.id("lastName"));
        lastNameLocator1.sendKeys(lastname1);
    }
    @When("user enters the employee ID {string}")
    public void user_enters_the_employee_id(String employeeID) {
        WebElement employeeIDLocator1= driver.findElement(By.id("employeeId"));
        employeeIDLocator1.sendKeys(employeeID);
    }
    @When("user enters the first name {string}")
    public void user_enters_the_first_name(String firstname2) {
        WebElement firstNameLocator2= driver.findElement(By.id("firstName"));
        firstNameLocator2.sendKeys(firstname2);
    }
    @When("user leaves the last name field empty")
    public void user_leaves_the_last_name_field_empty() {
        WebElement lastNameLocator2= driver.findElement(By.id("lastName"));
        lastNameLocator2.clear();
    }
    @When("user leaves the employee ID field empty")
    public void user_leaves_the_employee_id_field_empty() {
        WebElement employeeIDLocator2= driver.findElement(By.id("employeeId"));
        employeeIDLocator2.clear();
    }
    @Then("error message appears")
    public void error_message_appears() {
         WebElement errorMessage= driver.findElement(By.xpath("//input[@class='formInputText validation-error']"));
         assertTrue(errorMessage.isDisplayed());
    }

    @When("user is adding multiple employees with data table and saves them")
    public void user_is_adding_multiple_employees_with_data_table_and_saves_them
            (io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> employeeNames=dataTable.asMaps();
        for(Map<String, String> employee:employeeNames) {

            addEmployeePage.firstNameLocator.sendKeys(employee.get("firstName"));
            addEmployeePage.middleNameLocator.sendKeys(employee.get("middleName"));
            addEmployeePage.lastNameLocator.sendKeys(employee.get("lastName"));


            click(addEmployeePage.saveButton);
            WebElement addEmployee = driver.findElement(By.id("menu_pim_addEmployee"));
            click(addEmployee);
        }
    }
}
