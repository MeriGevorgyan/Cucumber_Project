Feature: Login related scenarios

  #Background:  Given user accesses the HRMS application

    @negative
  Scenario: Login attempt with empty password
    When user leaves username field empty
    And user enters a valid password
    And user clicks on login button
    Then error message "Username cannot be empty" appears

    @negative
  Scenario: Login attempt with empty username
    When user enters the valid username
    And user leaves password field empty
    And user clicks on login button
    Then error message "Password is empty" appears

    @negative
  Scenario: Login attempt with invalid username
    When user enters invalid username
    And user enters a valid password
    And user clicks on login button
    Then error message "Invalid credentials" appears

    @positive
  Scenario: User corrects empty username and attempts login again
    When user enters a valid username
    And user enters a valid password
    And user clicks on login button
    Then user successfully logs in

