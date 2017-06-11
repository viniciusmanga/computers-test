/**
 * 
 */
package com.backbase.computers.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

/**
 * @author viniciussilva
 * 
 */
@Component
public class ComputerPage extends AbstractPage {

	private final Logger LOG = Logger.getLogger("ComputerPage");

	@FindBy(id = "name")
	private WebElement computerName;

	@FindBy(id = "introduced")
	private WebElement introducedDate;

	@FindBy(id = "discontinued")
	private WebElement discontinuedDate;

	@FindBy(id = "company")
	private Select company;

	@FindBy(xpath = "//input[contains(@value, 'Create this computer')]")
	private WebElement createComputerButton;

	@FindBy(xpath = "//a[contains(text(), 'Cancel')]")
	private WebElement cancelButton;

	public void fillComputerName(String value) {
		computerName.clear();
		computerName.sendKeys(value);
	}

	public void fillIntroducedDate(String value) {
		introducedDate.clear();
		introducedDate.sendKeys(value);
	}

	public void fillDiscontinuedDate(String value) {
		discontinuedDate.clear();
		discontinuedDate.sendKeys(value);
	}
	
	public void fillCompany(String value) {
		company.selectByVisibleText(value);
	}

	public void save() {
		createComputerButton.click();
	}

	public boolean isErrorDisplayedOnField(String fieldName) {
		String xpath = String.format("//label[contains(text(), '%s')]//ancestor::div[contains(@class, 'clearfix error')]", fieldName);
		return getDriver().findElement(By.xpath(xpath)).isDisplayed();
	}

	@Override
	public boolean isLoaded() {
		return computerName.isDisplayed() && introducedDate.isDisplayed() && introducedDate.isDisplayed() && discontinuedDate.isDisplayed()
				 && createComputerButton.isDisplayed() && cancelButton.isDisplayed();
	}

	@Override
	public void waitUntilIsLoaded() {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 5000, 1000);
			wait.until(ExpectedConditions.visibilityOf(computerName));
			
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			LOG.warning("Page not loaded");
		}

	}

}
