Feature: patch user
  Scenario: I patch user
    Given I set a base API request
    When I request patch user
    Then I validate the status code patch user