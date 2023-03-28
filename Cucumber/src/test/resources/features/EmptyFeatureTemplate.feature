@Regression
Feature: Empty feature scenario for learning
  As an automation engineer
  I want to test the different things
  Using Java, cucumber and serenity

  @SomeTag1
  Scenario: This is a simple scenario
    Given This is an empty template without parameters
    When This is an empty template with one parameter 100


  @SomeTag2
  Scenario Outline: This is a scenario outline that uses more elements
    Given This is an empty template without parameters
    When This is an empty template with one parameter 100
    Then This is an empty template with 2 parameters <parameter1> and <parameter2>
    Examples:
      | parameter1  | parameter2  |
      | 1           | 101         |
      | 2           | 102         |
      | 3           | 103         |
      | 4           | 105         |

  @SomeTag3 @Web
  Scenario: This is a simple scenario that involves a browser
    Given I open the browser to "https://www.google.com/en"
    When I dismiss the privacy policy
    And I search for the string "summer"
    Then The results contain "summer"


  @SomeTagDemo
#    @Web
  Scenario Outline: This is a scenario outline that uses more elements
    Given I open the browser to "http://the-internet.herokuapp.com/challenging_dom"
    Given The title is "The Internet"
    And The content matches
    When I click the "Blue" button and verify it has text
    Then And the Header contains "<Headers>"
    And The table content should be "<Int>" "<Col1>" "<Col2>" "<Col3>" "<Col4>" "<Col5>" "<Col6>" "<Col7>"
    When I click the "Red" button and verify it has text
    Then And the Header contains "<Headers>"
    And The table content should be "<Int>" "<Col1>" "<Col2>" "<Col3>" "<Col4>" "<Col5>" "<Col6>" "<Col7>"
    When I click the "Green" button and verify it has text
    Then And the Header contains "<Headers>"
    And The table content should be "<Int>" "<Col1>" "<Col2>" "<Col3>" "<Col4>" "<Col5>" "<Col6>" "<Col7>"
    When I verify the canvas has a number
    Then I verify the top redirect
    Then I navigate back
    And I verify the bottom redirect
    Then I close the opened tab
    Examples:
      |Int |Col1	    |Col2    	|Col3	     |Col4	        |Col5	        |Col6	    |Col7        | Headers |
      |1   |Iuvaret0	|Apeirian0	|Adipisci0	 |Definiebas0   |Consequuntur0	|Phaedrum0	|edit delete | Lorem   |
      |2   |Iuvaret1	|Apeirian1	|Adipisci1	 |Definiebas1	|Consequuntur1  |Phaedrum1	|edit delete | Ipsum   |
      |3   |Iuvaret2	|Apeirian2	|Adipisci2	 |Definiebas2	|Consequuntur2	|Phaedrum2	|edit delete | Dolor   |
      |4   |Iuvaret3	|Apeirian3	|Adipisci3	 |Definiebas3	|Consequuntur3	|Phaedrum3	|edit delete | Sit     |
      |5   |Iuvaret4	|Apeirian4	|Adipisci4	 |Definiebas4	|Consequuntur4	|Phaedrum4	|edit delete | Amet    |
      |6   |Iuvaret5	|Apeirian5	|Adipisci5	 |Definiebas5	|Consequuntur5	|Phaedrum5	|edit delete | Diceret |
      |7   |Iuvaret6	|Apeirian6	|Adipisci6	 |Definiebas6	|Consequuntur6	|Phaedrum6	|edit delete | Action  |
      |8   |Iuvaret7	|Apeirian7	|Adipisci7	 |Definiebas7	|Consequuntur7	|Phaedrum7	|edit delete ||
      |9   |Iuvaret8	|Apeirian8	|Adipisci8	 |Definiebas8	|Consequuntur8	|Phaedrum8	|edit delete ||
      |10  |Iuvaret9	|Apeirian9	|Adipisci9	 |Definiebas9	|Consequuntur9	|Phaedrum9	|edit delete ||

  Scenario Outline: Timetracking
    Given I open the browser to "https://timetracking.nttdata.ro"
    When I log in with "<Username>" and "<Password>"
    And I select the dates as "<Day>" and "<Month>"
    Then I fill in the unallocated days
    Examples:
    |Username|Password|Day|Month|
    |ebs\razvanionel.rosca|PasswordEmea2021!@|02|January|