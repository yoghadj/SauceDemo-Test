Feature: Add Product in Cart
  Scenario Outline: Add product
    Given the user is opening login page
    When the user enter username "<username>" and password "<password>"
    And the user clicks the login button
    And user redirected to homepage
    And user click add button for product
    Then number in cart should change
    Examples:
      | username        | password       |
      | standard_user | secret_sauce |