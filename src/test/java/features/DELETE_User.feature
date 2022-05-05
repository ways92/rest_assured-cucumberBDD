Feature: delete user
  Scenario: I delete user
    Given I set a base API request
    When I request delete users by id
    Then I validate the status delete user