@Regression
Feature: Feature to test tables, links and others
  As an automation engineer
  I want to test the different things
  Using Java, cucumber and serenity


  @TableAndButtons @Web
  Scenario Outline: This is a scenario outline that tests the content of a table, the buttons and the redirection of links
    Given I open the browser to the page "http://the-internet.herokuapp.com/challenging_dom"
    Given The title is "The Internet"
    And The content matches
    When I click the "Blue" button and verify it has text
    When I click the "Red" button and verify it has text
    When I click the "Green" button and verify it has text
    Then And the Header contains "<Headers>"
    And The table content should be <Index> "<Col1>" "<Col2>" "<Col3>" "<Col4>" "<Col5>" "<Col6>"
    When I verify the canvas has a number
    Then I validate "Elemental Selenium" bottom link and close the tab
    Then I validate "GitHub" top link and navigate back

    Examples:
      | Index | Col1     | Col2      | Col3      | Col4        | Col5          | Col6      | Headers |
      | 0     | Iuvaret0 | Apeirian0 | Adipisci0 | Definiebas0 | Consequuntur0 | Phaedrum0 | Lorem   |
      | 1     | Iuvaret1 | Apeirian1 | Adipisci1 | Definiebas1 | Consequuntur1 | Phaedrum1 | Ipsum   |
      | 2     | Iuvaret2 | Apeirian2 | Adipisci2 | Definiebas2 | Consequuntur2 | Phaedrum2 | Dolor   |
      | 3     | Iuvaret3 | Apeirian3 | Adipisci3 | Definiebas3 | Consequuntur3 | Phaedrum3 | Sit     |
      | 4     | Iuvaret4 | Apeirian4 | Adipisci4 | Definiebas4 | Consequuntur4 | Phaedrum4 | Amet    |
      | 5     | Iuvaret5 | Apeirian5 | Adipisci5 | Definiebas5 | Consequuntur5 | Phaedrum5 | Diceret |
      | 6     | Iuvaret6 | Apeirian6 | Adipisci6 | Definiebas6 | Consequuntur6 | Phaedrum6 | Action  |
      | 7     | Iuvaret7 | Apeirian7 | Adipisci7 | Definiebas7 | Consequuntur7 | Phaedrum7 |         |
      | 8     | Iuvaret8 | Apeirian8 | Adipisci8 | Definiebas8 | Consequuntur8 | Phaedrum8 |         |
      | 9     | Iuvaret9 | Apeirian9 | Adipisci9 | Definiebas9 | Consequuntur9 | Phaedrum9 |         |