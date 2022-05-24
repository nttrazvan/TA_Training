@Regression
Feature: Scenario to test the creation of a lawyer of type RB
  As a user
  I want to be able to create lawyers of type RB
  Using Java, cucumber and serenity

  @OpenWizard @Web
    Scenario: This scenario tests the creation of lawyers of type RB
    Given I open the browser to "https://test.isb-ag.de/tpr/tpr/login"
    And I first enter the username "User1S"
    And I then enter the password "TPRBenutzer01!" and press submit
    Then Wait for the Dashboard to load
    Given I open the Akte page to "https://test.isb-ag.de/tpr/tpr/akte/1"
    Then I press the creation button of RB
#    Then I open the dropdown Anrede

    @Validations
    Scenario Outline: This scenario tests the field validations
      Given I leave the Anrede empty
      When I validate the fields <Vorname> and <Name>
      Examples:
        | Vorname  | Name  |
        | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa|aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa|
        | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa|aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa|