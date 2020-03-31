Feature: Validating place API'S


 @addPLace
   Scenario Outline: : Verifing if place is being add sucessfully added using Addplace API'

    Given Add Place Payload with "<name>" "<phone_number>" "<address>"
    When User calls "addPlaceAPI" API'S by "post" http request
    Then the API call got sucess with status code 200
    And  "status" in response body is "OK"
    And  "scope" in response body is "APP"
    And  verify place_id created maps to "<name>" using "getPlaceAPI"


    Examples:
    |name    |phone_number                 |address              |
    |  SHYD  | (+91) 88 893 3999           |   N SHALLOWFIORD    |
   # |  Shewli  | (718) 88 893 3999           |   N 75th street    |


 @deletePlace
 Scenario: Verify if delete Place functionality is working

     Given DeletePlace Payload
     When User calls "deletePlaceAPI" API'S by "post" http request
     Then the API call got sucess with status code 200
     And  "status" in response body is "OK"


