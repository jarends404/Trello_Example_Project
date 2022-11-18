@chrome @firefox @safari @deleteBoardAfter
Feature: As a user I want to interact with my board to keep track of the progress on my project

  Scenario: The user can view a board
    Given I create a new board
    When I visit my board
    Then my created board is visible
