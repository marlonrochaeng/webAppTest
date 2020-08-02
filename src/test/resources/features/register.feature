@regression
Feature: Register new user


  @scenario001
  Scenario: Register a new user with right info
    Given I open the browser in homepage
    And navigate to register page
    When I try to create a new user with valid information
    Then I should be redirected to login page


  @scenario002
  Scenario: Register a new user with wrong username
    Given I open the browser in homepage
    And navigate to register page
    When I try to create a new user with invalid username
    Then I should not be redirected to login page

