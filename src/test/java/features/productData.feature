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
  Scenario: Preenchendo o formulário Enter product Data
    Given informo a Start Date
    And seleciono a Insurance Sum
    When seleciono a Merit Rating
    And seleciono a Damage Insurance
    And seleciono o Optional Products
    And seleciono o Courtesy Car
    Then clico no nextselectpriceoption
      #Examples:
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
