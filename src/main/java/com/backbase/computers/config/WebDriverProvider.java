/**
 * 
 */
package com.backbase.computers.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author viniciussilva
 *
 */
@Component
public class WebDriverProvider {
	
	private static final String WEBDRIVER_PROPERTY = "webdriver.gecko.driver"; 
	
	@Value("${driver.location}")
	private String driverLocation;
	
	private WebDriver driver;
	
	public WebDriver getWebDriver() {
		System.setProperty(WEBDRIVER_PROPERTY, "src/main/resources/driver/geckodriver");
		
		if (driver == null) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	

}
