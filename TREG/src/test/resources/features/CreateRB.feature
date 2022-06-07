@Regression
Feature: Scenario to test the creation of a lawyer of type RB
  As a user
  I want to be able to create lawyers of type RB
  Using Java, cucumber and serenity

  Background:
    Given I open the browser to "https://test.isb-ag.de/tpr/tpr/login"
    And I first enter the username "User1S"
    And I then enter the password "TPRBenutzer01!" and press submit
    And Wait for the Dashboard to load

  @OpenAndValidateFirstAndLastName @Web
  Scenario Outline: This scenario tests the field validations for first name and last name
    When I open the Akte page to "https://test.isb-ag.de/tpr/tpr/akte/1"
    And I save the counter before creation
    And I press the creation button of RB
    And I select an option in the dropdown Anrede
    And I enter something in the fields "<Vorname>" and "<Name>"
    Then I should see the button "<Weiter>"
    Examples:
      | Vorname                                                                                               | Name                                                                                                  | Weiter   |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa | disabled |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa  | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa  | enabled  |

  @Create @Web
  Scenario: This scenario tests the field validations for date fields
    When I open the Akte page to "https://test.isb-ag.de/tpr/tpr/akte/1"
    And I press the creation button of RB
    And I select an option in the dropdown Anrede
    And I enter the first name "Liana" and the last name "Chis"
    Given I press Next
    Then I check the name "Liana"
    And I select a role
    And I enter a begin date "01.01.2022"
    And I enter an end date "01.10.2022"
    And I submit the wizard
    And I refresh the page
    Then I check the counter