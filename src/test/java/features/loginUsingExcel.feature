Feature: Login

#  @Run
#  Scenario Outline: Login with invalid credentials
#  As I user I should not be able to login to the app using wrong username
#
#    Given I load test data from "TestData" "SauceDemoData" "<row>"
#    And I am on the sauce demo login page
#    When I enter my username
#    And I enter my password
#    And I click login button
#    Then I should see error message "Epic sadface: Username and password do not match any user in this service"
#
#    Examples:
#      | row |
#      | 1   |
#      | 2   |
#      | 3   |


  @Run
  Scenario Outline: Login with invalid credentials
  As I user I should not be able to login to the app using wrong username

    Given I load test data from "TestData" "SauceDemoData" for "<tc_id>"
    And I am on the sauce demo login page
    When I enter my username
    And I enter my password
    And I click login button
    Then I should see error message "Epic sadface: Username and password do not match any user in this service"

    Examples:
      | tc_id   |
      | TC_0001 |
      | TC_0002 |
      | TC_0003 |