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
@tag 
Feature: Title of your feature 
	I want to use this template for my feature file

@regressao 
Scenario: Preenchendo o formulário Enter insurant Data 
	Given informo o First Name 
	And informo o Last Name 
	And informo a Birth Date 
	When seleciono o Gender 
	And seleciono o Country 
	And informo o Zip Code 
	And informo a Occupation 
	And seleciono o Hobbies 
	Then clico no nextenterproductdata 
	
	#Examples:
	#      | name  | value | status  |
	#      | name1 |     5 | success |
	#      | name2 |     7 | Fail    |
