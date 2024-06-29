@WI
Feature: Login page feature

  Background:
    Given User launch a browser

  Scenario Outline: Login with correct credentials
    When user click on Login Button
    Then user is on Login page
    When user enter email "<email>" and password "<password>"
    Then click on Login button
    Then page title should be "Automation Exercise"
    And user verify logout button
    And User close a browser

 Examples:
      | email                      | password       |
      | borle19aniruddha@gmail.com |Rani@123        |
      #| borle19aniruddha@gmail.com |Rani@123        |
      #| borle19aniruddha@gmail.com |Rani@123        |