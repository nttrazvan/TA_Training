@Regression
Feature: Emag home page feature
  As an enthusiastic intern
  I want to test the emag home page
  Using Java, cucumber and serenity

  @SomeTag @EmagHome
  Scenario: Check cart to be empty
    Given I open the browser to "https://www.emag.ro"
    When I agree with privacy policy
    And I hover the cart button
    Then The cart should contain text "nu ai niciun produs în coș"
