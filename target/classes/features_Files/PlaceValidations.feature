Feature: Validating places API's

  Scenario: Verify if places is been sucessfully aded using AddPlaceApi
    Given Add Place Payload
    When User calls AddPlaceApi with post http request
    Then The API call is sucessfull with status code 200
    And statis is response body is OK