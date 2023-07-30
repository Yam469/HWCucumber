Feature: Techfios billing login page functionality validation

Scenario: User Should be able to login with valid credentials
Given User is on the techfios login page
When User enters username as "demo@techfios.com"
When User enters password as "abc123"
When User clicks on Sign in button
Then User should land on dashboard page

Scenario: User Should be able to login with valid credentials
Given User is on the techfios login page
When User enters username as "demo@techfios.com"
When User enters password as "abc124"
When User clicks on Sign in button
Then User should not land on dashboard page
