@chrome @firefox @safari @deleteBoardAfter
Feature: As a user I want to interact with my board to keep track of the progress on my project

  Scenario: The user can view a board
    Given a new board
    When I visit my board
    Then my created board is visible

  Scenario: The user can add cards to his board
    Given a new board
    When I visit my board
    And I create a new card in the "To Do" list
    Then the card is displayed in the "To Do" list

  Scenario: The user can move cards to other lists
    Given a new board
    And a card in the "To Do" list
    When I visit my board
    And I move the card to the "Doing" list
    Then the card is displayed in the "Doing" list
