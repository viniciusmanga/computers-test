/**
 * 
 */
package com.backbase.computers.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author viniciussilva
 *
 */
@Component
public class WebDriverProvider {
	
	private static final String WEBDRIVER_PROPERTY = "webdriver.gecko.driver";
	
	private static final String WINDOWS_WEBDRIVER = "src/main/resources/driver/geckodriver-win.exe"; 
	
	private static final String MAC_WEBDRIVER = "src/main/resources/driver/geckodriver-mac";
	
	@Autowired
	private Environment env;

	private WebDriver driver;
	
	public WebDriver getWebDriver() {
		final String system = env.getProperty("systemType");
		
		if (system.equals("OSX")) {
			System.setProperty(WEBDRIVER_PROPERTY, MAC_WEBDRIVER);
		} else {
			System.setProperty(WEBDRIVER_PROPERTY, WINDOWS_WEBDRIVER);
		}
		
		if (driver == null) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}

}
