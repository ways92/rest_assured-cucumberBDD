Feature: get list users
  Scenario: I get list users
    Given I set a base API request
    Given I request get list users
    Then I validate the status code list users