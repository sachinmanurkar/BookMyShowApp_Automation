Feature: Test a scenario under BookMyShow app

  Scenario: To automate a basic scenario

    Given I launch the book my show App
    Then Select the language as English
    And Click on skip button
    Then Click on allow app to access device location
    Then Click on search icon on HomePage
    Then I search for "2.0" under search movie
    Then Verify the Page is displayed with selected movie name "2.0"
    Then Click on Book Tickets Button
    Then Select language Hindi and screentype 3D
    Then Select the date "20"
    Then Select the time "06:30 AM"
    Then Accept terms and conditions
    Then Select the number of seats as "2"
    Then Click on Select Seats
    Then Check Wheather it is Webview or native "Webview"
    Then Tap on the seats
    Then Tap on pay
    Then Click on skip button on seat selection page










