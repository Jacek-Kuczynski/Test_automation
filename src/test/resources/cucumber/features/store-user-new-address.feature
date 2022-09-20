Feature: Store User

  Scenario Outline: new address creation

    Given an open browser with https://mystore-testlab.coderslab.pl/
    And logged in
    When reached new address creation page
    Then filled form with new address data: <Alias>, <Address>, <City>, <Zip/Postal Code>, <Country>, <Phone>
    And confirmed added data
    And deleted added address

    Examples:
      | Alias   | Address            | City   | Zip/Postal Code | Country        | Phone       |
      | Adres 1 | ul. Pelplińska 111 | Gdynia | 81-258          | United Kingdom | 123-123-123 |


  Scenario: ordering clothes

    Given an open browser with https://mystore-testlab.coderslab.pl/
    And logged in
    When added Hummingbird Printed Sweater to cart
    And proceeded to check out (chopping cart)
    Then confirmed address, shipping method, payment
    And ordered with an obligation to pay (terms of service agreed)


