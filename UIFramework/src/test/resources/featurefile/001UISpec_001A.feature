Feature: HomePage

  @chrome
  Scenario Outline: Should List different Request Types And Endpoints
    Given  Open Chrome and Launch Application
    When  I click on "<requestType>"
    Then  I validate different requesttypes and endpoints

    Examples:
    | requestType | Code |
    | Single user not found | 404 |

    @chrome
    Scenario: Support page Validation
      Given  Open Chrome and Launch Application
      When I click on Support Button
      Then I navigated To Support page

  @chrome
  Scenario: Support page Options
    Given  Open Chrome and Launch Application
    When I click on Support Button
    Then I navigated To Support page
    And Two Options As OneTime and MonthlySupport Available




