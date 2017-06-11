Add a new Computer Story

Narrative:
As a User
I want to be able to access the Computers Web App
So that I can test the whole application

Scenario: Validate that the 'Dashboard page' is loaded
Given I am on the Computers dashboard page
When I am on the 'Dashboard' page
Then I should see the 'Dashboard' page loaded

Scenario: Validate that the 'Add a new computer page' is loaded
Given I am on the Computers dashboard page
When I click on the 'Add a new computer' button
Then I should see the 'Add a new computer' page displayed

Scenario: Validate that the 'Computer name' field is required
When I fill the 'Computer name' field with empty value
And I click on the 'Create new computer' button
Then I should see the highlighted error on the field 'Computer name'

Scenario: Validate that the 'Introduced date' field only accepts date on the format 'yyyy-MM-dd'
When I fill the 'Computer name' field with the value <computerName>
And I fill the 'Introduced date' field with the value <introducedDate>
And I click on the 'Create new computer' button
Then I should see the highlighted error on the field 'Introduced date'
Examples:
|	computerName	|	introducedDate	|
|	Test			|	Test			|
|	Test			|	01-01-2017		|
|	Test			|	01-31-2017		|
|	Test			|	99-99-2017		|
|	Test			|	2017-99-01		|
|	Test			|	2017-12-32		|
|	Test			|	2017-12-00		|

Scenario: Validate that the 'Discontinued date' field only accepts date on the format 'yyyy-MM-dd'
When I fill the 'Computer name' field with the value <computerName>
And I fill the 'Introduced date' field with the value <introducedDate>
And I fill the 'Discontinued date' field with the value <discontinuedDate>
And I click on the 'Create new computer' button
Then I should see the highlighted error on the field 'Discontinued date'
Examples:
|	computerName	|	introducedDate	|	discontinuedDate	|
|	Test			|	2017-01-01		|	Test				|
|	Test			|	2017-01-01		|	01-01-2017			|
|	Test			|	2017-01-01		|	01-31-2017			|
|	Test			|	2017-01-01		|	99-99-2017			|
|	Test			|	2017-01-01		|	2017-99-01			|
|	Test			|	2017-01-01		|	2017-12-32			|
|	Test			|	2017-01-01		|	2017-12-00			|

Scenario: Validate that a user can add a computer and sees the success message
Given I am on the Computers dashboard page
When I am on the 'Dashboard' page
And I click on the 'Add a new computer' button
And I should see the 'Add a new computer' page displayed
And I fill the 'Computer name' field with the value <computerName>
And I fill the 'Introduced date' field with the value <introducedDate>
And I fill the 'Discontinued date' field with the value <discontinuedDate>
And I fill the 'Company' field with the value <company>
And I click on the 'Create new computer' button
And I am on the 'Dashboard' page
Then I should see the sucess message on 'Dashboard' page
Examples:
|	computerName		|	introducedDate	|	discontinuedDate	|	company			|
|	Vini Computer A		|	2017-01-01		|	2017-12-31			|	Apple Inc.		|
|	Vini Computer B		|	2017-01-01		|	2017-12-31			|	Lenovo Group	|
|	Vini Computer C		|	2017-01-01		|	2017-12-31			|	Nintendo		|


Scenario: Validate that computers can be filtered by name
Given I am on the Computers dashboard page
When I am on the 'Dashboard' page
And I filter computers with the value <computerName>
And I am on the 'Dashboard' page
Then I should see the 'Computer name' <computerName> on the results table
Examples:
|	computerName	|
|	Vini Computer A	|
|	Vini Computer B	|
|	Vini Computer C	|

Scenario: Validate that the application shows the computer details
Given I am on the Computers dashboard page
When I am on the 'Dashboard' page
And I filter computers with the value <computerName>
And I am on the 'Dashboard' page
And I click on the 'Computer name' <computerName> on the results table
Then I should see the 'Add a new computer' page displayed
Examples:
|	computerName	|
|	Vini Computer A	|
|	Vini Computer B	|
|	Vini Computer C	|

Scenario: Validate that computers can be edited
Given I am on the Computers dashboard page
When I am on the 'Dashboard' page
And I filter computers with the value <computerName>
And I am on the 'Dashboard' page
And I click on the 'Computer name' <computerName> on the results table
And I fill the 'Computer name' field with the value <computerNameUpdated>
And I click on the 'Create new computer' button
And I am on the 'Dashboard' page
Then I should see the sucess message on 'Dashboard' page
Examples:
|	computerName			|	computerNameUpdated		|
|	Vini Computer A 		|	Vini Computer A Updated	|
|	Vini Computer B 		|	Vini Computer B Updated	|
|	Vini Computer C 		|	Vini Computer C Updated	|

Scenario: Validate that computers can be deleted sucessfully
Given I am on the Computers dashboard page
When I am on the 'Dashboard' page


