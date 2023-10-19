Feature: Checkout Product
  Scenario Outline: Checkout product
    Given user access login page
    When user input username "<username>" and password "<password>"
    And user login with given username password
    And user redirected to all product page
    And user add product to cart
    And user click cart
    And user redirected to cart page
    And user click checkout button
    And user redirected to input form
    And user input first name "<first_name>" last name "<last_name>" and postal code "<postal>"
    And user click continue button
    And user redirected to checkout overview page
    And user click finish button
    Then user redirect to thank you page
    Examples:
      | username | password | first_name | last_name | postal |
      | standard_user | secret_sauce | Yogha | Julianto | 11111|