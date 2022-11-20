@chrome @firefox @safari @deleteBoardAfter
Feature: As a user I want to interact with my board to keep track of the progress on my project

  Scenario: The user can view a board
    Given a new board is displayed
    Then my created board's default elements are visible

  Scenario: The user can add cards to his board
    Given a new board is displayed
    When I create a new card in the "To Do" list
    Then the card is displayed in the "To Do" list

  Scenario: The user can move cards to other lists
    Given a new board is displayed
    And there is a card in the "To Do" list
    When I move the card to the "Doing" list
    Then the card is displayed in the "Doing" list
