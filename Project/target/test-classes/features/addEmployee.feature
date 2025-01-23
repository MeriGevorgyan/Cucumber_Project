Feature: Add Employee

  Background:
    #Given user accesses the HRMS application
    When user enters admin username and password
    And user clicks on login button
    Then user is able to see dashboard page
    When user clicks on PIM button
    And user clicks on Add Employee option

  Scenario: Adding employee without providing an ID
    When user provides the first name "John"
    And  user provides the last name "Brown"
    And  user leaves employee ID field empty
    And  user clicks on save button
    And  employee's details should be saved


  Scenario: Adding employee by employee ID
    When user enters first name "Ann"
    And  user enters last name "Smith"
    And  user enters the employee ID "E12345"
    And  user clicks on save button
    Then employee's details should be saved

  Scenario: Adding an employee with invalid incomplete information
      When user enters the first name "Josh"
      And user leaves the last name field empty
      And user leaves the employee ID field empty
      And  user clicks on save button
      Then error message appears


      @data
   Scenario: Adding multiple employees with data table
     When user is adding multiple employees with data table and saves them
       | firstName | middleName | lastName |
       |Mark       | MS         |Antony    |
       |Jane       |Lucy        |Green     |
       |Kate       |MS          |Brain     |


