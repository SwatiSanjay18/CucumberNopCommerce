
Feature: Login
  @basiclogin
  Scenario: Successful login with valid credentials
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin" 
    And Click on login button
    Then  Page title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page title should be "Your store. Login"
    And Close browser
      
	@mixdatalogin
  Scenario Outline: Login data driven
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<pwd>" 
    And Click on login button
    Then  Page title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page title should be "Your store. Login"
    And Close browser 
    
    Examples:
             | email | pwd |
             | admin@yourstore.com | admin |
             | admin@yourstore.com | admin123 |