Feature: Datatable Functionality
  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

    Scenario: Create Country
      And Click on the element in the left Nav
      |setupOne|
      |parameters|
      |Countries|

      And Click on the elemen in the Dialog
      |createCountry|

      And User sending the keys in Dialog content
        |nameInput|Morbidanya1|
        |Code     |1234567891|

      And Click on the elemen in the Dialog
      |SaveButton|

      And Success Message should be displayed

      And User delete item from Dialog
        |Morbidanya1|
      And Success Message should be displayed

      Scenario: Create a Nationality
        And Click on the element in the left Nav
          |setupOne|
          |parameters|
          |nationality|
        And Click on the elemen in the Dialog
          |createCountry|
        And User sending the keys in Dialog content
          |nameInput|İsmailov1|
        And Click on the elemen in the Dialog
          |SaveButton|
        And Success Message should be displayed
        And User delete item from Dialog
          |İsmailov1|
        And Success Message should be displayed

        Scenario: Create a Fee,delete fee
          And Click on the element in the left Nav
            |setupOne|
            |parameters|
            |Fees|
          And Click on the elemen in the Dialog
            |createCountry|
          And User sending the keys in Dialog content
            |nameInput|İsmailov1|
            |Code     |1234567891|
            |intCode  |456|
            |priority |287|
          And Click on the elemen in the Dialog
            |activateButton|
          And Click on the elemen in the Dialog
            |SaveButton|
          And Success Message should be displayed

          And User delete item from Dialog
            |İsmailov1|
