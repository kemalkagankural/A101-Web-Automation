@E2e @Regression
Feature: e2e make order tests

  @e2eMakeOrder
  Scenario Outline: e2e make order test
    Given user is opened A101 Website
    When focus "<category-name>" category
    And click "<branch>" branch
    And filter "<color>" color
    Then user see products
    When click a product
    And click add to basket
    And go to cart
    Then user verifies  product information that price,product code,"<color>","<count>", is correct on cart
    When go to payment phase
    Then click continue without a member
    And write "<email>"
    And click continue button
    And click create new Address
    And fill "<adressheader>","<name>","<surname>","<phone>","<city>","<town>","<neighbourhood>" informations
    And select cargo option
    Then click save&continue button
    Then user should see payment screen
    Examples:
      | category-name    | branch        | color | count | email                | adressheader | name | surname | phone       | city     | town   | neighbourhood |
      | Giyim & Aksesuar | Dizaltı Çorap | SİYAH | 1     | yerdobapsa@vusra.com | ev           | test | tester  | 05312173362 | İSTANBUL | ADALAR | 35388         |