@chrome @firefox @safari @deleteBoardAfter
Feature: As a user I want to add details to my cards so I know exactly what the card entails

  Scenario: The user can add labels
    Given a new board is displayed
    And there is a card in the "To Do" list
    When the user adds a label to the card
    Then the label is displayed