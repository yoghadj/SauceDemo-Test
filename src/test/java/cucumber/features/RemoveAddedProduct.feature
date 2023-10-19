Feature: Remove Added Product from Cart
  Scenario Outline: Remove Added product
    Given the user access login page
    When the user enter "<username>" and "<password>" for username password
    And the user logins
    And user redirected to product list
    And user add product
    And user view the product added to cart
    And user click remove button for added product
    Then product back to first state
    Examples:
      | username        | password       |
      | standard_user | secret_sauce |