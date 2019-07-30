Feature: Movie DB App
  In order to look at Movie DB
  As a Registered user
  I want to specify the flow to Movie app

  Scenario: Verify Avenger movie appeared in home screen
    Given user is on Application Home Page
    Then I verify movie "TheAvengers" appeared in home screen

  Scenario: Verify Movie detail page displays movie name
    Given user is on Application Home Page
    When user choose movie "TheAvengers"
    Then "TheAvengers" movie detail page displayed

  Scenario: Navigate to Movie detail page
    Given user is on Application Home Page
    When user tap on movie co-ordinates "TheAvengers"
    Then "TheAvengers" movie detail page displayed