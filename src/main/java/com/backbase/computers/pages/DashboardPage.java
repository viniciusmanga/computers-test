/**
 * 
 */
package com.backbase.computers.pages;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author viniciussilva
 * 
 */
@Component
public class DashboardPage extends AbstractPage {
	
	private final Logger LOG = Logger.getLogger("DashboardPage");

	@Value("${computers.url}")
	private String dashboardUrl;

	@FindBy(id = "searchbox")
	private WebElement searchBox;

	@FindBy(xpath = "//input[contains(@value, 'Filter by name')]")
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

	public void searchComputers(String value) {
		searchBox.clear();
		searchBox.sendKeys(value);
		filterByNameButton.click();
	}

	public void clickOnAddButton() {
		addButton.click();
	}

	public void clickOnComputerName(String value) {
		List<WebElement> results = computerList.findElements(By.xpath(String.format("//tbody//a[contains(text(), '%s')]", value)));

		if (!CollectionUtils.isEmpty(results)) {
			WebElement result = results.get(0);
			if (result.getText().equals(value)) {
				result.click();
			}
		}
	}

	public String getSuccessMessage() {
		return successMessage.getText();
	}

	public String getFirstSearchResultName() {
		List<WebElement> results = computerList.findElements(By.xpath("//tbody//a"));
		return !CollectionUtils.isEmpty(results) ? results.get(0).getText() : "";
	}

	@Override
	public boolean isLoaded() {
		return addButton.isDisplayed() && searchBox.isDisplayed() && filterByNameButton.isDisplayed() && computerList.isDisplayed();
	}

	@Override
	public void waitUntilIsLoaded() {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 5000, 1000);

			wait.until(ExpectedConditions.visibilityOf(computerList));

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			LOG.warning("Page not loaded");
		}

	}

}
