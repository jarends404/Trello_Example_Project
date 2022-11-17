@chrome @firefox @safari
Feature: As a user I want to be able to login so I can order products

  Scenario: The user is able to login
    Given I am on the page "/"
    When I enter valid credentials
    Then I am logged in
