Feature: Citizenship with scenario Outline

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly
    And Navigate to Citizenship

  Scenario Outline: Citizenship create
   When User a Citizenship name as "<CitizenshipName>" shortname as "<ShortName>"
    Then Success Message should be displayed

    When User a Citizenship name as "<CitizenshipName>" shortname as "<ShortName>"
    Then Already exist message should be displayed
    And Click on close button
    When User delete the "<CitizenshipName>"
    Then Success Message should be displayed
    Examples:
      |CitizenshipName  | ShortName |
      |Dore41           | Dore2     |
      |Dore42           | Dore2     |
      |Dore43           | Dore2     |
      |Dore44           | Dore2     |
      |Dore45           | Dore2     |
      |Dore46           | Dore2     |


