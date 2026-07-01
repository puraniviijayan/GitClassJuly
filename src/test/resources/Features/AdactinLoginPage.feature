Feature: Validation of adactin login web application

  Background: 
    Given User is on adactin login page
	
  Scenario: Validation of login page with valid credential
    When User enters valid username and password
    And Clicks on login button
    Then User is navigates to Search hotel page

  Scenario: Validation of login page with Invalid credential
    When User enters Invalid username and password
    And Clicks on login button
    Then Invalid login error message is display

  Scenario Outline: Validation of login with valid username and invalid password
    When User enters valid username as "<username>" and invalid password as "<password>"
    And Clicks on login button
    Then Invalid login error message is display

    Examples: 
      | username         | password  |
      | Soundariyagreens | hello@123 |
      | Soundariyagreens | hello@567 |
      | Soundariyagreens | hello@789 |

  @SearchHotel
  Scenario: Validation of search hotel mandatory fields
    When User enters valid username and password
    And Clicks on login button
    Then User is navigates to Search hotel page
    When User enters location and noOfRooms and checkInDate and checkOutDate and adultsPerRoom and Clicks on Search button
      | location    | noOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | New York    | 2 - Two   | 24/01/2025  | 25/01/2025   | 1 - One       |
      | Paris       | 2 - Two   | 25/01/2025  | 26/01/2025   | 1 - One       |
      | Los Angeles | 2 - Two   | 26/01/2025  | 27/01/2025   | 1 - One       |
