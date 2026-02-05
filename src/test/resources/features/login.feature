Feature: Instagram Login

  @positive @smoke
  Scenario: Success login with valid credentials
    Given User is on the Login page
    When User inputs a valid User ID and password
    And User clicks the Login button
    Then User should be redirected to the Profile page

Feature: Instagram Login

  @negative
  Scenario: Failed login with invalid credentials
    Given User is on the Login page
    When User inputs an invalid User ID or password
    And User clicks the Login button
    Then User should see an error message "Invalid username or password"
    And User remains on the Login page