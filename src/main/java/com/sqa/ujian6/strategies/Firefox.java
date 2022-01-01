package com.sqa.ujian6.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox implements DriverStrategy {

	public WebDriver setStrategy() {
		System.setProperty("webdriver.gecko.driver", "C:/Web Driver/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		
		return new FirefoxDriver(options);
	}

}
