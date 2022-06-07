Feature: Products end point CRUD tests
  As a user,I want to perform below actions on BestBuyApi.

  Scenario: Verify user can create new product successfully
    When user sends a POST request to products endpoint
    Then User must get back a valid status code 201 from products endpoint
    And User verify newly added product name in record

  Scenario: Verify user can read product data successfully
    When user sends a GET request to productsID endpoint
    Then User must get back valid status code 200 from product
    And  User verify product name in record

  Scenario: Verify user can update product successfully
    When user sends a PATCH request to productsID endpoint
    Then User must get back valid status code 200 from products endpoint
    And  User verify updated product name in record

  Scenario: Verify user can delete product successfully
    When user sends a DELETE request to productsID endpoint
    Then User must get back valid status code 200 from products
    And  User verify deleted product name not found in record


