Feature: Country Multi Scenario

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly
    And Navigate to country page

  Scenario: Ceate Country

    When Create a country
    Then Success Message should be displayed

    Scenario: Create a country parameter data

      When Create a country name as "Mami" code as "code07"
      Then Success Message should be displayed
