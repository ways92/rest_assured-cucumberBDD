Feature: get list unknown
  Scenario: I get list unknown
    Given I set a base API request
    When I request get list unknown
    Then I validate the status code list unknown