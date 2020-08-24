Feature: login

  Scenario: Login using correct id
    Given user go to katalon demo web
    When user click on login menu on the sidebar
    And user fill out correct login data
    Then user is in success login page
