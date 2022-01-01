package com.sqa.ujian6.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.txt")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;
	
	@Value("${myusername}")
	private String userName;
	
	@Value("${email}")
	private String email;
	
	@Value("${password}")
	private String password;
	
	public String getBrowser() {
		return browser;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
