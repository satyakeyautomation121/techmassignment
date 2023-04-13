
@tag
Feature: Add Functionality

  @tag1
  Scenario Outline: Add User
    Given I set a POST employee service endpoint
    When I set request Header
    And Send a HTTP request
    Then I receive a valid responsecode <statuscode>
    Examples:
      | statuscode |
      | 201        |


