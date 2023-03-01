Feature: Update the created user info

  Scenario Outline: Change the name or the job of the user
    Given User new "<name>" and "<job>"
    When we call put api
    Then the API call got success with the status 200
    And verify if the name and job is changed

    Examples:
      | name  | job                |
      | Hakan | Software Developer |
      | Garip | Business Analyst   |
      | Esat  | Software Engineer  |
      | Ilhan | Business Manager   |