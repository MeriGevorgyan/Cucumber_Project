Feature: Add Employee

  Background:
    When user enters admin username and password
    And user clicks on login button
    Then user is able to see dashboard page
    When user clicks on PIM button
    And user clicks on Add Employee option


      @data
   Scenario: Adding multiple employees with data table
     When user is adding multiple employees with data table and saves them
       | firstName | middleName | lastName | employeeId|
       |Mark       | MS         |Antony    |  ""       |
       |Jane       |Lucy        |Green     | 12345     |
       |Kate       |   ""       | ""       |  ""       |

    When  user clicks on save button
    Then employee's details should be saved or error message should appears


