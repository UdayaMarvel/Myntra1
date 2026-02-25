@Filters
Feature: Filter validation

Background: Launch and Mouse over to Men
Given Launch the Myntra Application "https://www.myntra.com/"


#	Scenario: Categories Filter Validation
#		When User mouse over to Men
#		And User clicks on T-Shirts
#		Then Validate the T-Shirts page loaded
#		When User clicks on Categories with one dim list
#		|Lounge Tshirts|
#		|Tshirts|
#		Then Validate the filters with one dim map
#		|Filter1|Lounge Tshirts|
#		|Filter2|Tshirts|
#		And Verify the count matches the products
	
	@Lounge
	Scenario Outline: Categories Filter Validations
		When User mouse over to Men
		And User clicks on T-Shirts
		Then Validate the T-Shirts page loaded
		When User clicks on Categories "<Filter>"
		Then Validate the filters "<Filter>"
#		And Verify the count matches the products
		
	Examples:
	|Filter					|
	|Lounge Tshirts	|
#	|Tshirts				|

	@Tshirts
	Scenario Outline: Categories Filter Validations
		When User mouse over to Men
		And User clicks on T-Shirts
		Then Validate the T-Shirts page loaded
		When User clicks on Categories "<Filter>"
		Then Validate the filters "<Filter>"
#		And Verify the count matches the products
		
	Examples:
	|Filter					|
	|Tshirts|