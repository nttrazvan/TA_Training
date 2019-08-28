@Regression
Feature: Empty feature scenario for learning
  As an automation engineer
  I want to test the different things
  Using Java, cucumber and serenity

  @SomeTag1
  Scenario: This is a simple scenario
    Given This is an empty template without parameters
    When This is an empty template with one parameter "100"


  @SomeTag2
  Scenario Outline: This is a scenario outline that uses more elements
    Given This is an empty template without parameters
    When This is an empty template with one parameter "100"
    Then This is an empty template with 2 parameters "<parameter1>" and "<parameter2>"
    Examples:
      | parameter1  | parameter2  |
      | 1           | 101         |
      | 2           | 102         |
      | 3           | 103         |
      | 4           | 105         |

  @SomeTag3
  Scenario: This is a simple scenario that involves a browser
    Given I open the browser to "https://www.google.com/en"
    When I search for the string "summer"
    Then The results contain "summer" at least once