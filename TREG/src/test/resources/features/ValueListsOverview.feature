@Regression
Feature: Scenario to test the Value Lists Overview
  As an administrator
  I want to be able to manage the value lists
  Using Java, cucumber and serenity

  @ValueListsOverview @Web
    Scenario: This scenario tests the Value Lists Management component
    Given I open the browser to "https://test.isb-ag.de/tpr/tpr/login"
    When I first enter the username "User1A"
    And I then enter the password "TPRBenutzer01!" and press submit
    And I navigate to the Value Lists Overview
    Then I check that a paginator exists
    Then I check that sorting works
    Then I check that the filter for string "num" and returns following values: "Telefonnummer" and "Faxnummer"
    Then I check that filtering and sorting can be reset through the reset button
