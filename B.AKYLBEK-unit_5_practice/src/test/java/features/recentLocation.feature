Feature: Recent Location
  I am a user
  I want to use recent locations
  to quickly access previously viewed weather details

  Scenario: Check recent locations functionality
    Given I open the Weather page
    When I input "London" in the search field
    And I click on the first search result
    And I navigate back to the main page
    Then Main page is displayed
    When I choose the first city in Recent locations
    Then the city weather page header contains "London"