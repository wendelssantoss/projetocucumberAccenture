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
  Scenario: Preenchendo o formulário Send Quote
    Given informo o EMail
    And informo o Username
    When informo o Password
    And confirmo o Password
    And clico no sendemail
    And Sera exibida a mensagem na tela
    Then clico no ok
      #Examples:
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
