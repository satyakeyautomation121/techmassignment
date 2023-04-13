
@tag
Feature: Add Functionality

  @tag1
  Scenario Outline: List Of Users
    Given A list of users available
    When Client requests to get users
    Then The Response code should be <statuscode>
    Examples:
      | statuscode |
      |  200       |

