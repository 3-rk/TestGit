Feature: Login_Test

  Scenario: Login_Test
    Given url is launched
    When user clicks on book appointment
    And user logs in with valid uid and pwd
    Then user books appointments

