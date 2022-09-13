Feature: Store User

  Scenario Outline: new address creation

    Given an open browser with https://mystore-testlab.coderslab.pl/
    And logged in
    When reached new address creation page
    Then filled form with new address data: <Alias> <Address> <City> <Zip/Postal Code> <Country> <Phone>
    And confirmed the new address

    Examples:
      | Alias | Address | City | Zip/Postal Code | Country | Phone |
      | Adres 1 | ul. Pelplińska 111 | Gdynia | 81-258 | United Kingdom | 123-123-123 |
