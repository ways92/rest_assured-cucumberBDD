Feature: get single unknown
  Scenario: I get single unknown
    Given I set a base API request
    When I request get single unknown
    Then I validate the status code single unknown