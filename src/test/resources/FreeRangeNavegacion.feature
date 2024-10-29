# @Navigation
# Feature: Navigation bar
#     To see the subpages
#     Without logging in
#     I can click the navigation bar links

# Background: I am on the Free Range Testers web without logging in.
#     Given I navigate to www.freerangetesters.com

# # Scenario Outline: I can access the subpages through the navigation bar
# #     When I go to <section> using the navigation bar
# #     Examples:
# #         | section |
# #         | Cursos  |
# #         | Recursos  |
# #         | Blog  |
# #         | Mentorías  |
# #         | Udemy  |

# Scenario: Courses are presented correctly to potential customers
#     When I go to Cursos using the navigation bar
#     And I select Introduccion al Testing

# @Plans
# Scenario: Users can select a plan when signing up
#     When The client selects Elegir Plan
#     Then The client can validate the options in the checkout page

Feature: Sandbox Page Validation

@sandboxValidation
Scenario: Validate text and link on the Sandbox page
    Given The user navigates to the Sandbox page
    Then The user verifies the text displayed is correct
    And The user verifies the link to FRT

@sandboxValidation
Scenario: Validate the dynamic button
    Given The user clicks the dynamic button
    Then The user verifies the text is displayed after 3 seconds

@sandboxValidation
Scenario: Select all checkboxes
Given The user selects all checkboxes
Then The user verifies that all checkboxes are selected

@sandboxValidation
Scenario: Select the "No" radio button
Given The user selects the No radio button
Then The user verifies that the No radio button is selected

@sandboxValidation
Scenario: Validate the pop-up
Given The user clicks on Mostrar pop up
Then The user verifies the pop up text
And I click the Cerrar button

@sandboxValidation
Scenario: Verify that the dynamic table contains specific values
   Given The dynamic table is loaded with values
   Then The user verifies that all values are present in the table

@sandboxValidation
Scenario: Validate static table data
    Given The following expected data:
        | 1  | Messi  | 35   | messi@example.com    |
        | 2  | Ronaldo| 38   | ronaldo@example.com  |
        | 3  | Mbappe | 24   | mbappe@example.com   |
    Then Verify it matches the info on the page
