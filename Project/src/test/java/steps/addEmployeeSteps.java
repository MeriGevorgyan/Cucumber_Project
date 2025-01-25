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

    //@When("user leaves employee ID field empty")
   // public void user_leaves_employee_id_field_empty() {
      //  WebElement employeeIDLocator= driver.findElement(By.id("employeeId"));
     //   employeeIDLocator.clear();
   // }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveButton= driver.findElement(By.id("btnSave"));
        click(saveButton);
    }

    //@When("user leaves the employee ID field empty")
    //public void user_leaves_the_employee_id_field_empty() {
    //    WebElement employeeIDLocator2= driver.findElement(By.id("employeeId"));
     //   employeeIDLocator2.clear();
    //}

    @When("user is adding multiple employees with data table and saves them")
    public void user_is_adding_multiple_employees_with_data_table_and_saves_them
            (io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> employeeNames = dataTable.asMaps();
        for (Map<String, String> employee : employeeNames) {

            addEmployeePage.firstNameLocator.sendKeys(employee.get("firstName"));
            addEmployeePage.middleNameLocator.sendKeys(employee.get("middleName"));
            addEmployeePage.lastNameLocator.sendKeys(employee.get("lastName"));

            click(addEmployeePage.saveButton);
            WebElement addEmployee = driver.findElement(By.id("menu_pim_addEmployee"));
            click(addEmployee);
        }
    }
        @Then("employee's details should be saved or error message should appears")
        public void employee_s_details_should_be_saved_or_error_message_should_appears() {
            WebElement errorMessage= driver.findElement(By.xpath("//input[@class='formInputText validation-error']"));
            assertTrue(errorMessage.isDisplayed());
            WebElement employeeList= driver.findElement(By.id("menu_pim_viewEmployeeList"));
            assertTrue(employeeList.isDisplayed());
        }
    }

