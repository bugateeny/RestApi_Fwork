Feature: Dodds Interface Jobs call-Out

# @TestRun
  Scenario Outline: 1. I want a job completion to be updated automatically to sandwell’s atrium system when a repair is completed in Dodd’s Vixen system.
    Given Service is up and running
    When I search for a "<jobID>" with GET method
    Then Then I should get correct "<jobNo>", "<siteAccount>" and "<orderNumber>" returned with status code of 200

    Examples:
      | jobID       | jobNo  | siteAccount | orderNumber |
      | 01M00095049 | M00095 | ADE001      | DODDS00     |
      | 01M00095048 | M00095 | ADE001      | DODDS00     |
      | 01M00095047 | M00095 | ADE001      | DODDS00     |
      | 01M00095046 | M00095 | ADE001      | DODDS00     |
      | 01M00095045 | M00095 | ADE001      | DODDS00     |
      | 01M00095044 | M00095 | ADE001      | DODDS00     |
      | 01M00095043 | M00095 | ADE001      | DODDS00     |

  @Regression
  Scenario Outline: 2. I want a job completion to be updated automatically to sandwell’s atrium system when a repair is completed in Dodd’s Vixen system.
    Given Service is up and running
    When I create a new API job call-out with the following mandatory fields "<companyNumber>","<contact>","<description>","<uprn>","<orderNumber>","<priority>" and "<interfaceJob>" with POST method
    Then Then I should validate correct "<siteAccount>","<jobNo>" and "<jobId>" returned with job created status code of 201

    Examples:
      | companyNumber | contact  | description          | uprn      | orderNumber | priority | siteAccount | jobNo  | jobId    | interfaceJob |
      | 01            | Adey BDD | New Callout via BDD1 | DODDS-REF | DODDS00     | 1        | ADE001      | M00095 | 01M00095 | true         |
#      | 01            | Adey BDD | New Callout via BDD2 | DODDS-REF | DODDS00     | 2        | ADE001      | M00095 | 01M00095 | true         |
#      | 01            | Adey BDD | New Callout via BDD3 | DODDS-REF | DODDS00     | 3        | ADE001      | M00095 | 01M00095 | false        |
#      | 01            | Adey BDD | New Callout via BDD4 | DODDS-REF | DODDS00     | 4        | ADE001      | M00095 | 01M00095 | true         |
#      | 01            | Adey BDD | New Callout via BDD5 | DODDS-REF | DODDS00     | 5        | ADE001      | M00095 | 01M00095 | false        |