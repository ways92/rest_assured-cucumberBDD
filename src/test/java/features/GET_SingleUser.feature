Feature: get single user
  Scenario: I get single user
    Given I set a base API request
    Given I request get single users
    Then  I validate the status code single user