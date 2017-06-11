/**
 * 
 */
package com.backbase.computers.steps;

import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backbase.computers.pages.DashboardPage;

/**
 * @author viniciussilva
 *
 */
@Component
public class DashboardSteps {
	
	@Autowired
	public DashboardPage page;
	
	
	@Given("I am on the Computers dashboard page")
	public void navigateToDashboardPage() {
		page.navigateToDashboardPage();
	}
	
	@When("I am on the 'Dashboard' page")
	public void loadDashboardPage() {
		page.waitUntilIsLoaded();
	}
	
	@When("I click on the 'Add a new computer' button")
	public void clicOnAddComputer() {
		page.clickOnAddButton();
	}
	
	@Then("I should see the 'Dashboard' page loaded")
	public void isPageDisplayed() {
		Assert.assertTrue(page.isLoaded());
	}
	
	@Then("I should see the sucess message on 'Dashboard' page")
	public void getSucessMessage() {
		Assert.assertTrue(StringUtils.isNotEmpty(page.getSuccessMessage()));
	}

}
