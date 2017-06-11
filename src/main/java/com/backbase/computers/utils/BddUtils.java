/**
 * 
 */
package com.backbase.computers.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backbase.computers.config.WebDriverProvider;

/**
 * @author viniciussilva
 *
 */
@Component
public class BddUtils {
	
	@Autowired
	private WebDriverProvider provider;
	
	public void tinyWait() throws InterruptedException {
		provider.getWebDriver().wait(1500);
	}

}
