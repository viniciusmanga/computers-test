/**
 * 
 */
package com.backbase.computers.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backbase.computers.pages.ComputerPage;

/**
 * @author viniciussilva
 * 
 */
@Component
public class ComputerSteps {

	@Autowired
	private ComputerPage page;
	
	@When("I fill the 'Computer name' field with empty value")
	public void fillComputerNameWithEmptyValue() {
		page.fillComputerName(" ");
	}
	
	@When("I fill the 'Computer name' field with the value $value")
	public void fillComputerName(@Named("value") String value) {
		page.fillComputerName(value);
	}
	
	@When("I fill the 'Introduced date' field with the value $value")
	public void fillIntroducedDate(@Named("value") String value) {
		page.fillIntroducedDate(value);
	}
	
	@When("I fill the 'Discontinued date' field with the value $value")
	public void fillDiscontinuedDate(@Named("value") String value) {
		page.fillDiscontinuedDate(value);
	}
	
	@When("I fill the 'Company' field with the value $value")
	public void fillCompany(@Named("value") String value) {
		page.fillCompany(value);
	}

	@When("I click on the 'Create new computer' button")
	public void createComputer() {
		page.save();
	}

	@When("I click on the 'Save this computer' button")
	public void updateComputer() {
		page.update();
	}
	
	@Then("I click on the 'Delete this computer' button")
	public void deleteComputer() {
		page.delete();
	}

	@When("I am on the 'Add a new computer' page")
	public void loadDashboardPage() {
		page.waitUntilIsLoaded();
	}

	@Then("I should see the 'Add a new computer' page displayed")
	public void isPageDisplayed() {
		Assert.assertTrue(page.isLoaded());
	}
	
	@Then("I should see the highlighted error on the field '$fieldName'")
	public void isErrorDisplayed(@Named("fieldName") String fieldName) {
		page.waitUntilIsLoaded();
		Assert.assertTrue(page.isErrorDisplayedOnField(fieldName));
	}
	

}
