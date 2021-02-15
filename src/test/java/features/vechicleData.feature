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
Feature: Vechicle Data 

	I want to use this template for my feature file

@regressao 
Scenario: Preenche o formulario Enter Vechicle Data 
	Given estou na pagina inicial 
	And seleciono o make 
	And seleciono o model 
	And informo o cylindercapacity 
	And informo os dados do Engine Performance 
	And seleciono a Date of Manufacture 
	When seleciono o Number of Seats 
	And seleciono o Number of Seats2 
	And seleciono o Fuel Type 
	And informo o Payload 
	And informo o Total Weight 
	And informo o List Price 
	And informo o Annual Mileage 
	Then clico no nextInsurant 
	
	#	Examples: 
	#		| name  | value | status  |
	#		| name1 |     5 | success |
	#		| name2 |     7 | Fail    |
