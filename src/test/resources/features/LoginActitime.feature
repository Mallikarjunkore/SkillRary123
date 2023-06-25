
Feature: Login of Actitime

  Scenario: Login with valid credentials
    Given Launch browser and enter actitime url
    When login credentials are entered
    And login button is clicked
    Then Actitime home page should display
  