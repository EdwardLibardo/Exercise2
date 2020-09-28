Feature: User with an account in the ESPN page


  Background:
    Given i am in the main page of "https://www.espn.com/src=com&_adblock=true"
    When i create an account with with "Cristiano" "Ronaldo" "@gmail.com" "Password2020*"

  Scenario: creating a new account
    Then i am able to see the page as a registered user

  Scenario: log Out to my profile
    And i click on the Log Out button
    Then i am logged out

  Scenario: log in to my profile
    And i click on the Log Out button
    Then i am able to log in on the page
    And i am able to see the page as a registered user

  Scenario: deleting the account
    And i delete the account
    Then i am logged out