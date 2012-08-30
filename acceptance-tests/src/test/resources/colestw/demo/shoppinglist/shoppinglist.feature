Feature: Shopping List

  Scenario: Say hello
    Given I have a hello app with "Howdy"
    When I ask it to say hi
    Then it should answer with "Howdy World"

  Scenario: Create a new shopping shopping list
    When I visit the Coles Shopping List site
    And I create a new shopping list
    Then I should have a shopping list
