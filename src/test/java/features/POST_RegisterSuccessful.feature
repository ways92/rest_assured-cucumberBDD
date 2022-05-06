Feature: register successful
  Scenario: I register successful
    Given I set a base API request
    When I request post register successful
    Then I validate the status code post register successful