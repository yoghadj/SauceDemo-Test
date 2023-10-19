Feature: User login to Application

  Scenario Outline: Successful login
    Given the user is on the login page
    When the user enters valid "<username>" as username
    And the user enters valid "<password>" as password
    And clicks the login button
    Then the user should got the result "<status>"
    Examples:
      | username        | password       | status |
      | standard_user | secret_sauce | success    |
      | locked_out_user | secret_sauce | failed    |
