Feature: Login_Test

  Scenario Outline: Login_Test
    Given url is launched
    When user clicks on book appointment
    And user logs in with valid "<uid>" and "<pwd>"
    Then user books appointments with data
      | facilityName                    | dateOfappt | comments                    |
      | Hongkong CURA Healthcare Center | 12/05/2019 | Test Automation appointment |

    Examples:
      | uid      | pwd                |
      | John Doe | ThisIsNotAPassword |