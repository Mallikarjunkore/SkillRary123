
Feature: Actitime login 
  Scenario Outline: Login with multiple data
    Given User launches browser and enters actitime url
    When User enters <username> and <password>
    And clicks on login
    Then home Page <status> is displayed

    Examples: 
      | username  | password | status  |
      | admin     |  manager | success |
      | trainee   |  trainee | success |
      | abcd      |  efgh    | fail    |
