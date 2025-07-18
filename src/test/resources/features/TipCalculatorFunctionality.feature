Feature: Tip Calculator Functionality
  As a user
  I want to calculate tips correctly
  So that I can know how much to pay

  Scenario: Test the tip calculation with valid inputs
    Given I navigate to the tip calculator page
    When I enter "1000" as the bill amount
    And I enter "15" as the tip percentage
    And I click the calculate button
    Then I should see the tip amount as "150.00"
    And I should see the total amount as "1150.00"