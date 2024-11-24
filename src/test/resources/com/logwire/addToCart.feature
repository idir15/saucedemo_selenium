Feature: Add article to cart
  I want to add articles 

  Background:
    Given I am on the webpage "https://www.saucedemo.com/"
    When I enter my username "standard_user" and I enter my password "secret_sauce" and click on the login button
    Then I am logged in to my account

  Scenario: User click on the button of the first item in the list display to add into the card
    When I click on add to cart on the first item in the list
    And I click on the cart button
    Then the cart should containt the selected item
