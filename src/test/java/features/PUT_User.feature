Feature: put user
  Scenario: I put user
    Given I set a base API request
    When I request put user
    Then I validate the status code put user