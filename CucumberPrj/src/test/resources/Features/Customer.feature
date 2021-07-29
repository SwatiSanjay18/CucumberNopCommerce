Feature: Customer
  @regression
  Scenario: Add new customer
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on login button
    Then Page title should be "Dashboard / nopCommerce administration"
    Then User clicks on Customers Menu
    Then User clicks on Customers on SubMenu
    When User clicks on Add new button
    Then Page title should be "Add a new customer / nopCommerce administration"
    Then Add new customer details
    When User click on Save button
    Then Page should have "The new customer has been added successfully."
    And Close browser
