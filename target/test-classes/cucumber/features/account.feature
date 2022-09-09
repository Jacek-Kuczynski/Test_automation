Feature: Hotel Users

  Scenario: new account creation

    Given an open browser with https://hotel-testlab.coderslab.pl/en/
    When new user register
    Then an account is created
    And close browser

  Scenario Outline: new account can be created for given users

    Given an open browser with https://hotel-testlab.coderslab.pl/en/
    When a user with <name> and <lastname> is registered
    Then an account is created
    And close browser

    Examples:
      | name | lastname    |
      | jan  | januszewski |
      | tom  | tomaszewski |
      | paw  | pawslowski  |

  Scenario: adding first address to account

    Given an opened browser with https://hotel-testlab.coderslab.pl/en/
    And logged in
    When adding a new address
    And new address form filling
    Then new address is added
    And close browser


