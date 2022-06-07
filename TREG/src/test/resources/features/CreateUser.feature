@Regression
Feature: Scenario to test the creation of users
  As an administrator
  I want to be able to create users
  Using Java, cucumber and serenity

  @CreateUser @Web
  Scenario Outline: This scenario tests the creation of a user
    Given I open the browser to "http://localhost:8080/tpr/tpr/login"
    And I first enter the username "User1A"
    And I then enter the password "TPRBenutzer01!" and press submit
    Given I navigate to the User Overview
    And I press the creation button
    And I enter: first name "<Vorname>", last name "<Name>", email "<E-Mail>", phone number "<Telefon>", extension "<Durchwahl>", role "<Rollenzuweisung>", "<Referat>" and "<Team>"
    Examples:
      | Vorname    | Name     | E-Mail         | Telefon       | Durchwahl | Rollenzuweisung                    | Referat | Team   |
      | Margit     | Heinner  | abs@abs.com    | +49 22899 358 | 10        | Administration                     | VM II 5 | Team 1 |
      | Margarette | Heinz    | abc@abc.com    | +49 22899 358 | 11        | Gesamtleitung                      | VM II 6 | Team 2 |
      | Charlotte  | Heinrich | tada@abc.com   | +49 22899 358 | 11        | Leitung                            | VM II 5 | Team 3 |
      | Laura      | Peinlich | tadaa@abc.com  | +49 22899 358 | 11        | Teamleitung                        | VM II 5 | Team 4 |
      | Priscilla  | Holgen   | tadaad@abc.com | +49 22899 358 | 12        | Sachbearbeitung                    | VM II 5 | Team 5 |
      | Clara      | Metz     | pampam@abc.com | +49 22899 358 | 13        | 'Sachbearbeitung (eingreschränkt)' | VM II 6 | Team 6 |
      | Paula      | Metz     | pacpac@abc.com | +49 22899 358 | 14        | Bürosachbearbeitung                | VM II 6 | Team 7 |
      | Natalia    | Fritz    | pompom@abc.com | +49 22899 358 | 15        | Gast                               | VM II 5 | Team 8 |
