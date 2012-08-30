Feature: Shopping List

  Scenario: Say hello
    Given I have a hello app with "Howdy"
    When I ask it to say hi
    Then it should answer with "Howdy World"

  Scenario: Login to shopping list site
    When I visit the Coles Shopping List site
    And I log in
    Then I should see my dashboard
