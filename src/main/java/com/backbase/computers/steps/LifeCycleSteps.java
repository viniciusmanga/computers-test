/**
 * 
 */
package com.backbase.computers.steps;

import org.jbehave.core.annotations.AfterStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backbase.computers.config.WebDriverProvider;

/**
 * @author viniciussilva
 *
 */
@Component
public class LifeCycleSteps {
	
	@Autowired
	private WebDriverProvider provider;
	
	@AfterStory
	public void afterStory() {
		provider.getWebDriver().quit();
	}

}
