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

#   Scenario: Select all checkboxes
#     Given the user selects all checkboxes

#   Scenario: Select the "No" radio button
#     Given the user selects the "No" radio button

#   Scenario: Select a sport from the dropdown and submit
#     Given the user selects "Basketball" from the sports dropdown
#     And the user clicks "Enviar"

#   Scenario: Select a day from the day of the week dropdown
#     Given the user selects "Domingo" from the day of the week dropdown

#   Scenario: Validate the pop-up
#     Given the user clicks "mostrar pop up"
#     Then the user verifies the pop-up
#     And the user verifies the text "¿Viste? ¡Apareció un Pop-up!"
#     And the user clicks the "Cerrar" button

#   Scenario: Validate static table data
#     Given the user verifies the data in the static table
    # (Specify which row or column you want to validate)
