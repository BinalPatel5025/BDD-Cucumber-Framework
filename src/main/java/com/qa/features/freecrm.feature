Feature: Free CRM Appllication Test

Scenario: Validate Free CRM Home Page Test

	Given user opens browser
	Then user is on login page
	When user logs into app
	Then validate Home page title
	Then Validate logged in username
	Then user close browser
