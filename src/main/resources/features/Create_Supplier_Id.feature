Feature:  Create a SupplierId

Background:
  Given your are connected to server

  @Regression
  Scenario Outline: I want to manage all supplier accounts in Supplier Management software and for all updates/changes to feed through to Vixen.
  I don't have to enter the Supplier’s details twice.

    Given Service is up and running
    When I enter all the essential elements to create PL account load, like "<companyNumber>","<suppliersId>","<name>","<address>","<sortKey>", if it is a subcontractor include the follow "<subcontractor>", "<subconVatNumber>"
    Then Then I should validate "<suppliersId>" and status code returns 200

    Examples:
      | companyNumber | suppliersId | name         | address             | sortKey | subcontractor | subconVatNumber |
      | 01            | 01ADE37    | PL_API Test1 | 307;Wolves;Wolves;; | API1    | true          | 898989887       |
#      | 01            | 01ADE052    | PL_API Test2 | 307;Wolves;;Wolves; | API2    | true          | 898989887       |
#      | 01            | 01ADE053    | PL_API Test3 | 307;Wolves;Wolves;  | API3    | true          | 898989887       |


#Feature: Credit card payment
#  In order to test Credit Card Payment functionality
#  As a CC user
#  I want to complete the payment through online
#
#  Scenario: Make Minimum Due payment
#    Given user is on Pay credit card page
#    Then user fills all details and select Minimum amount option
#    And User clicks on Pay button
#    Then Credit Card confirmation page is displayed
#
#  Scenario: Pay Statement Balance
#    Given user is on Pay credit card page
#    Then user fills all details and select Statement Balance option
#    And User clicks on Pay button
#    Then Credit Card confirmation page is displayed

#  Scenario: Enter another Amount as 0
#    Given user is on Pay credit card page
#    Then user fills all details and select other Amount and enter 0
#    And User clicks on Pay button
#    Then Credit Card confirmation page is not displayed  +++ Postive test
#    But error message is displayed ++++  Negative testing
