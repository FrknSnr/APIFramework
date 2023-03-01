Feature: Create User API

  Scenario Outline: Verify if creating is being successfully done
    Given User "<name>" and "<job>"
    When we call Post API with post http request
    Then the API call got success with status 201
    And verify the users' "<name>" and "<job>"

    Examples:
      | name   | job           |
      | Furkan | SDET          |
#      | Berka  | QA Engineer   |
#      | SeGe   | Manuel Tester |
#      | Asaf   | Manager       |