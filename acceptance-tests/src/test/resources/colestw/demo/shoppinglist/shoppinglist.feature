Feature: Shopping List

  Scenario: Say hello
    Given I have a hello app with "Howdy"
    When I ask it to say hi
    Then it should answer with "Howdy World"

  Scenario: Login to shopping list site
    Given I visit the Coles Shopping List site
    When I log in
    Then I should see my dashboard

  Scenario: Adding a new item to an empty shopping list
    Given I visit the Coles Shopping List site
    When I log in
    And my shopping list is empty
    And I add a shopping item to the list
      | name  | count |
      | Apple |     1 |
    Then the shopping list should look like:
    """
    1 Apple

    """

  Scenario: Clicking a project group so that the group can be viewed
    Given I visit the Coles Shopping List site
    When I log in
    And I select a project group
    Then I can see the list of items in the group

  Scenario: Adding a new item to the project group
    Given I visit the Coles Shopping List site
    When I log in
    And I select a project group
    And I enter a new item
#    Then I can see that the item has been added to the list
