Feature: Login
  As I user I should be able to login to the app

  Background: I am on sauce demo login page
    Given I am on the sauce demo login page

  Scenario: Login with valid credentials
  As I user I should be able to login to the app using valid username and password

    When I enter my username "standard_user"
    And I enter my password "secret_sauce"
    And I click login button
    Then I should be logged in
    And I should be able to see products

  Scenario: Login with invalid username
  As I user I should not be able to login to the app using wrong username

    When I enter my username "standard_user2"
    And I enter my password "secret_sauce"
    And I click login button
    Then I should see error message "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login with invalid password
  As I user I should not be able to login to the app using wrong password

    Given I am on the sauce demo login page
    When I enter my username "standard_user"
    And I enter my password "secret_sauce2"
    And I click login button
    Then I should see error message "Epic sadface: Username and password do not match any user in this service"

  Scenario Outline: Login with invalid credentials
  As I user I should not be able to login to the app using wrong username

    When I enter my username "<username>"
    And I enter my password "<password>"
    And I click login button
    Then I should see error message "<errorMessage>"

    Examples:
      | username       | password      | errorMessage                                                              |
      | standard_user2 | secret_sauce  | Epic sadface: Username and password do not match any user in this service |
      | standard_user2 | secret_sauce  | Epic sadface: Username and password do not match any user in this service |
      | standard_user2 | secret_sauce2 | Epic sadface: Username and password do not match any user in this service |
