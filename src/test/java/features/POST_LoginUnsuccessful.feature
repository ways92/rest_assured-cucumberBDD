Feature: register successful
  Scenario: I register unsuccessful
    Given I set a base API request
    When I request post login unsuccessful
    Then I validate the status code post login unsuccessful