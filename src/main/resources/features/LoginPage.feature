Feature: Login Page

	Scenario: Testing login page
		Given User go to the Website
		When User click dismiss button
		And User click my account button
		And User input username email password and click Login
		Then User can login to the Website