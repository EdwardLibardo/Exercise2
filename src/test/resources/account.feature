Feature: User with an account in the ESPN page


  Scenario: creating a new account
    Given i am in the main page of "https://www.espn.com/src=com"
    When i create an account with with "Cristiano" "Ronaldo" "ronaldo23232@gmail.com" "Password2020*"
    Then i am able to see the page as a registered user


  Scenario: Log Out to my profile
    Given i am in the main page of "https://www.espn.com/src=com&_adblock=true"
    When I am insert my credentials
    Then i am able to see the page as a registered user