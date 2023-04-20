@EcommerceWebsite
Feature: Login to Ecommerce Website

  @logintoWebsite
  Scenario: Login to Ecommerce Website with API Call
    Given LogintoWebsite Payload
    When User calls the "LogintoWebsite" API with "Post" http Request
    Then The API call got success and verify if the status code is 200
    And Verify the "message" at responsebody is "Login Successfully"
    
   @CreateProduct
  Scenario: Create a Product in website using API call
    Given CreateProduct Payload
    When User calls the "CreateProductAPI" API with "Post" http Request
    Then The API call got success and verify if the status code is 201
    And Verify the "message" at responsebody is "Product Added Successfully" 
    
    @CreateOrder
  Scenario: Create an Order in website using API call
    Given CreateOrder Payload
    When User calls the "CreateOrderAPI" API with "Post" http Request
    Then The API call got success and verify if the status code is 201
    And Verify the "message" at responsebody is "Order Placed Successfully"
    
    @getOrderDetails
  Scenario: GetOrder details in website using API call
    Given OrderId for getting Orderdetails
    When User calls the "GetOrderDetails" API with "get" http Request
    Then The API call got success and verify if the status code is 200
    And Verify the "message" at responsebody is "Orders fetched for customer Successfully"
    
    
    @DeleteOrder
  Scenario: Delete an Order in website using API call
    Given Delete an order by passing ProductId
    When User calls the "DeleteOrder" API with "Delete" http Request
    Then The API call got success and verify if the status code is 200
    And Verify the "message" at responsebody is "Product Deleted Successfully"
    
    
    
