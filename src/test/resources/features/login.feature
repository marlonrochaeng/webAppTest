@regression
Feature: Login


  @scenario003
  Scenario: Perform a correct login
    Given I open the browser in homepage
    And try to login with the right information
    Then I should be redirected to the logged area


  @scenario004
  Scenario Outline: Perform an incorrect login attempt
    Given I open the browser in homepage
    And try to login with the wrong information
    Then I should be able to see the "<error>" alert

Examples:
	|error													 |
	|ERRO! Usuário ou Senha inválidos|
