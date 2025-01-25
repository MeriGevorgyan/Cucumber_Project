Feature: Login related scenarios

  #Background:  Given user accesses the HRMS application

    @negative
  Scenario: Login attempt with empty password or username
    When user leaves username or password field empty
    And user clicks on login button
    Then error message "Username cannot be empty" or "Password is empty" appears

    @negative
  Scenario: Login attempt with invalid username
    When user enters invalid username or password
    And user clicks on login button
    Then error message "Invalid credentials" appears

    @positive
  Scenario: User corrects empty username and attempts login again
    When user enters a valid username and password
    And user clicks on login button
    Then user successfully logs in

