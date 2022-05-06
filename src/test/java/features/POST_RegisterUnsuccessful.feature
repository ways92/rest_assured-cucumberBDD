Feature: register unsuccessful
  Scenario: I register unsuccessful
    Given I set a base API request
    When I request post register unsuccessful
    Then I validate the status code post register unsuccessful