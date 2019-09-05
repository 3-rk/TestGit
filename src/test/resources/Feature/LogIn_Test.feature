Feature: Login_Test

  Scenario Outline: Login_Test
    Given url is launched
    When user clicks on book appointment
    And user logs in with valid "<uid>" and "<pwd>"
    Then user books appointments with data
      | facilityName                    | dateOfappt | comments                    |
      | Hongkong CURA Healthcare Center | 12/05/2019 | Test Automation appointment |
      | Tokyo CURA Healthcare Center    | 03/06/2019 | Test automation appt        |
      | Tokyo CURA Healthcare Center    | 26/07/2019 | Test automation appt        |

    Examples:
      | uid      | pwd                |
      | John Doe | ThisIsNotAPassword |
