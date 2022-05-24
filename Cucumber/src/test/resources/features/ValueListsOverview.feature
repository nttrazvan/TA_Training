@Regression
Feature: Scenario to test the Value Lists Overview
  As an administrator
  I want to be able to manage the value lists
  Using Java, cucumber and serenity

  @ValueListsOverview @Web
    Scenario: This scenario tests the Value Lists Management component
    Given I open the browser to "http://localhost:8080/tpr/tpr/login"
    And I first enter the username "User1A"
    And I then enter the password "TPRBenutzer01!" and press submit
    Given I navigate to the Value Lists Overview
    Then The page title is "Wertelisten Übersicht - Transparenzregister"
    And The table title is "Wertelisten Übersicht"
    Then The table header contains "Bezeichnung Werteliste", "Typ" and "Aktionen"
    And I verify the table content "Adressmuster und -hinweise", "Faxnummer" and the buttons
