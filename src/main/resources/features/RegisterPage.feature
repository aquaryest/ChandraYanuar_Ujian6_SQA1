Feature: Register Page
 
Scenario: Testing register page
		Given User go to the Website
		When User click dismiss button
		And User click my account button
		And User input username email password and click Register
		Then User can register to the Website