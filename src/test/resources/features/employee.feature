@regression
Feature: Register new employee


  @scenario005
  Scenario Outline: Register a new employee
    Given Im logged in
    When I create a new employee
    Then I should be able to see the success alert "<msg>"

	Examples:
	|msg																		|
	|SUCESSO! Usuário cadastrado com sucesso|
	
	
	@scenario006
  Scenario Outline: Edit a employee
    Given Im logged in
    When I edit an employee name
    Then I should be able to see the success alert "<msg>"

	Examples:
	|msg																	  		|
	|SUCESSO! Informações atualizadas com sucesso|
	
	
  @scenario007
  Scenario Outline: Delete a new employee
    Given Im logged in
    When I create a new employee
    And I delete this employee
    Then I should be able to see the success alert "<msg>"

	Examples:
	|msg																		|
	|SUCESSO! Funcionário removido com sucesso|