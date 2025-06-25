Feature: Current Location
  I am a user
  I want to search the city
  to be able to check the weather

  Scenario: Verify the current location label
    Given I open the Weather page
    When I click the search field
    Then the Use your current location label is displayed