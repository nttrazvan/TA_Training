@Regression
Feature: Feature to test date pickers and differences between two dates
  As an automation engineer
  I want to test the different things
  Using Java, cucumber and serenity


  @Scenario1 @Web
  Scenario Outline: This is a scenario outline that tests date pickers and differences between two dates including the end date
    Given I open the browser to the page containing a date calculator "https://www.timeanddate.com/date/duration.html"
    When I accept the privacy policy
    When I select a start date: <Start Day> "<Start Month>" <Start year>
    And I select an end date: <End Day> "<End Month>" <End year>
    And I submit the form including the end date
    And I calculate difference between start date and end date "including" the end date
    Then I validate the result on the page "including" the end date
    Examples:
      | Start Day | Start Month | Start year | End Day | End Month | End year |
      | 16        | November    | 2022       |13       |January    |2023      |

  @Scenario2 @Web
  Scenario Outline: This is a scenario outline that tests date pickers and differences between two dates excluding the end date
    Given I open the browser to the page containing a date calculator "https://www.timeanddate.com/date/duration.html"
    When I accept the privacy policy
    When I select a start date: <Start Day> "<Start Month>" <Start year>
    And I select an end date: <End Day> "<End Month>" <End year>
    And I submit the form excluding the end date
    And I calculate difference between start date and end date "excluding" the end date
    Then I validate the result on the page "excluding" the end date
    Examples:
      | Start Day | Start Month | Start year | End Day | End Month | End year |
      | 16        | November    | 2022       |13       |January    |2023      |

  @Scenario3 @Web
  Scenario Outline: This is a scenario outline that tests date pickers and differences between two dates including the end date and excluding weekends
    Given I open the browser to the page containing a date calculator "https://www.timeanddate.com/date/duration.html"
    When I accept the privacy policy
    When I select a start date: <Start Day> "<Start Month>" <Start year>
    And I select an end date: <End Day> "<End Month>" <End year>
    And I include the end date
    And I exclude weekends
    And I submit the dates form
    And I calculate difference between start date and end date "including" the end date and excluding the weekends
    Then I validate the result on the page "including" the end date and excluding the weekends
    Examples:
      | Start Day | Start Month | Start year | End Day | End Month | End year |
      | 16        | November    | 2022       |13       |January    |2023      |

  @Scenario4 @Web
  Scenario Outline: This is a scenario outline that tests date pickers and differences between two dates including the end date and only the public holidays
    Given I open the browser to the page containing a date calculator "https://www.timeanddate.com/date/duration.html"
    When I accept the privacy policy
    When I select a start date: <Start Day> "<Start Month>" <Start year>
    And I select an end date: <End Day> "<End Month>" <End year>
    And I include the end date
    And I include only Public Holidays
    And I submit the dates form
    Then I validate the result on the page including the end date and the public holidays
    Examples:
      | Start Day | Start Month | Start year | End Day | End Month | End year |
      | 16        | November    | 2022       |13       |January    |2023      |

  @Scenario5 @Web
  Scenario Outline: This is a scenario outline that tests date pickers and differences between two dates including the end date and only the weekends
    Given I open the browser to the page containing a date calculator "https://www.timeanddate.com/date/duration.html"
    When I accept the privacy policy
    When I select a start date: <Start Day> "<Start Month>" <Start year>
    And I select an end date: <End Day> "<End Month>" <End year>
    And I include the end date
    And I include only Weekends
    And I submit the dates form
    Then I validate the result on the page "including" the end date and only the weekends
    Examples:
      | Start Day | Start Month | Start year | End Day | End Month | End year |
      | 16        | November    | 2022       |13       |January    |2023      |