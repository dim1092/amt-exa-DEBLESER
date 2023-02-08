Feature: Application exam

Scenario: Register a new product
  Given I have a product payload
  When I POST it to the /produits endpoint
  Then I receive a 201 status code

Scenario: Register a new product
  Given I have a product payload
  When I POST it to the /produits endpoint
  And I receive a 201 status code
  Then I receive a url pointing to that product

Scenario: Get a product from its id
  Given I have a product payload
  And I POST it to the /produits endpoint
  And I receive a 201 status code
  When I GET it thru the given Id
  Then The descriptions corresponds to the created one

Scenario: Get a product from its id
  Given I have a product payload
  And I POST it to the /produits endpoint
  And I receive a 201 status code
  When I GET it thru the given Id
  Then The weight corresponds to the created one

Scenario: Get a product from its id
  Given I have a product payload
  And I POST it to the /produits endpoint
  And I receive a 201 status code
  When I GET it thru the given Id
  Then The delivery city corresponds to the created one