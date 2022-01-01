Feature: Add To Chart Page

	Scenario: Testing add to chart page
		Given User go to the Website
		When User click dismiss button
		And User click my account button
		And User input username email password and click Login
		And User click home page pick any order
		And User click pick option color size and click add to Chart
		Then User can add order to Chart