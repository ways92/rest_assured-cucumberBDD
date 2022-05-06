Feature: get delayed response
  Scenario: I get delay response
    Given I set a base API request
    When I request delay response
    Then I validate the status code delay response