Feature: post user
  Scenario: I post new user
    Given I set a base API request
    When I request post user
    Then I validate the status code post user