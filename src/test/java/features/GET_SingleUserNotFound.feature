Feature: get user not found
  Scenario: I get user not found
    Given I set a base API request
    When I request get single users not found
    Then  I validate the status code single user not found