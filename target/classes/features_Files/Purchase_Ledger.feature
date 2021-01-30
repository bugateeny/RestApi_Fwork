Feature:  Create a Purchase Ledger Account / link as a Subcontractor Account

  @Regression
  Scenario Outline: I want to manage all supplier accounts in Supplier Management software and for all updates/changes to feed through to Vixen.
  I don't have to enter the Supplier’s details twice.

    Given Service is up and running
    When I enter all the essential elements to create PL account load, like "<companyNumber>","<suppliersId>","<name>","<address>","<sortKey>", if it is a subcontractor include the follow "<subcontractor>", "<subconVatNumber>"
    Then Then I should validate "<suppliersId>" and status code returns 200

    Examples:
      | companyNumber | suppliersId | name         | address             | sortKey | subcontractor | subconVatNumber |
      | 01            | 01ADE14     | PL_API Test1 | 307;Wolves;Wolves;; | API1    | true          | 898989887       |
#      | 01            | 01ADE052    | PL_API Test2 | 307;Wolves;;Wolves; | API2    | true          | 898989887       |
#      | 01            | 01ADE053    | PL_API Test3 | 307;Wolves;Wolves;  | API3    | true          | 898989887       |


