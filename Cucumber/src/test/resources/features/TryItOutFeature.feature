@Regression
Feature: Try it out feature scenario for learning how to test with Cucumber
  As an automation engineer
  I want to test the different things
  Using Java, cucumber and serenity

  @E2E @Web
  Scenario: I want to search something on Amazon
    Given I navigate to the Amazon DE "https://www.amazon.com/de" URL
    When I dismiss the privacy policy
    And I search for the string "JBL"
    Then The results contain "JBL"




