#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: User Management Module

  Scenario: Add a new user
    Given I am logged in and on the user management page
    When I add a new user with valid details
    Then the new user should be listed in the users table

  Scenario: Edit an existing user
    Given I am logged in and on the user management page
    When I edit an existing user's details
    Then the changes should be reflected in the user details

  Scenario: Delete a user
    Given I am logged in and on the user management page
    When I delete a user I previously added
    Then the user should no longer be listed in the users table

  Scenario: Search for a user
    Given I am logged in and on the user management page
    When I search for a specific user
    Then the search results should display the matching user

  Scenario: Filter users by role
    Given I am logged in and on the user management page
    When I filter users by role
    Then the results should only show users with the selected role