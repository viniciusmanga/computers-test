/**
 * 
 */
package com.backbase.computers.pages;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author viniciussilva
 * 
 */
@Component
public class DashboardPage extends AbstractPage {

	@Value("${computers.url}")
	private String dashboardUrl;
	
	@FindBy(id = "searchbox")
	private WebElement searchBox;
	
	@FindBy(id = "searchsubmit")
	private WebElement filterByNameButton;
	
	@FindBy(xpath = "//table[contains(@class, 'computers')]")
	private WebElement computerList;
	
	@FindBy(id = "add")
	private WebElement addButton;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-message warning')]")
	private WebElement successMessage;

	public void navigateToDashboardPage() {
		getDriver().get(dashboardUrl);
	}

	public void clickOnAddButton() {
		addButton.click();
	}
	
	public String getSuccessMessage() {
		return successMessage.getText();
	}

	@Override
	public boolean isLoaded() {
		return addButton.isDisplayed() && searchBox.isDisplayed()
				&& filterByNameButton.isDisplayed() && computerList.isDisplayed();
	}

	@Override
	public void waitUntilIsLoaded() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 5000, 1000);
		
		wait.until(ExpectedConditions.visibilityOf(computerList));
		
	}

}
