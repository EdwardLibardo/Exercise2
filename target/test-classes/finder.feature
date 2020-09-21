Feature: Using wikipedia

Scenario: Wikipedia
 Given I am an user using "https://www.wikipedia.org"
 And I search for "Java"
 When I use the article page to search by "Hola Mundo"
 Then I can see the expected results