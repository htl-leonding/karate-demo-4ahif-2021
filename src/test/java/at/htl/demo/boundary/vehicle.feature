Feature: Get infos about our vehicles

  Background:
    * url baseUrl

  Scenario: Show single car
    Given path 'demo'
    And header Content-Type = 'application/json'
    # have to use the extension .txt, because of the automatic conversion from csv to json
    When method GET
    Then status 200
    And match response ==
    """
     {
        "type":"Admiral",
        "brand":"Opel"
     }
    """

  Scenario: Create a car
    Given path 'demo'
    And header Content-Type = 'application/json'
    And request { "type":"Admiral", "brand":"Opel" }
    When method POST
    Then status 201
    And print responseHeaders

