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
Then I should see the 'Dashboard' page loaded
And I should see the sucess message on 'Dashboard' page
Examples:
|	computerName	|	introducedDate	|	discontinuedDate	|	company			|
|	Vini I			|	2017-01-01		|	2017-12-31			|	Apple Inc.		|
|	Vini II			|	2017-01-01		|	2017-12-31			|	Lenovo Group	|
|	Vini III		|	2017-01-01		|	2017-12-31			|	Nintendo		|


Scenario: Validate that computers can be filtered by name


Scenario: Validate that the application shows the computer details


Scenario: Validate that computers can be edited


Scenario: Validate that computers can be deleted sucessfully


