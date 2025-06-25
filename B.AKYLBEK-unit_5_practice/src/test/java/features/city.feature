Feature: City
  I am a user
  I want to search the city
  to be able to check the weather

  Scenario: Check the city
    Given I open the Weather page
    When I input "New York" in the search field
    Then search results are displayed
    And I click on the first search result
    Then the city weather page header contains "New York"
