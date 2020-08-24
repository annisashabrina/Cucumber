Feature: Shopping Cart

  Scenario: Add to cart from product category
    Given customer has logged in
    When customer searched "laptop" product
    And customer add first item to the cart
    Then product has been submitted to the cart