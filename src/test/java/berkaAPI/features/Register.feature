Feature: Validation Register API

  @Register
  Scenario: Verify if registering is being successfully done
    Given Add Client Payload with "<name>" and "<email>"
    When  user calls "AddClientAPI" with post http request
    Then  the API call got success with status code 201
