
Feature: Registered user add's items to cart
  @additemstocard @smoke @regression
  Scenario Outline: Capaturing cart data
    Given registerd user adds nexusmobile "<units>" to cart
    And Asus devices to cart successfully
    Then registered user validates total amount successfull "<total>"

  Examples:
    |total|units|
    |1530  |2   |
