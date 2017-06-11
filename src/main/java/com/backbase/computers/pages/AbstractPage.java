/**
 * 
 */
package com.backbase.computers.pages;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backbase.computers.config.WebDriverProvider;

/**
 * @author viniciussilva
 * 
 */
@Component
public abstract class AbstractPage {

	@Autowired
	private WebDriverProvider provider;

	@PostConstruct
	public void init() {
		PageFactory.initElements(getDriver(), this);
	}

	public abstract boolean isLoaded();

	public abstract void waitUntilIsLoaded();

	public WebDriver getDriver() {
		return provider.getWebDriver();
	}
}
