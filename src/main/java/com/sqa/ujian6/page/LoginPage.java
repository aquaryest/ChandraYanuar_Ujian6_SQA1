package com.sqa.ujian6.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sqa.ujian6.driver.DriverSingleton;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".woocommerce-store-notice__dismiss-link")
	private WebElement btnDismiss;
	
	@FindBy(css = ".pull-right > li:nth-child(2) > a:nth-child(1)")
	private WebElement btnMyAccount;
	
	@FindBy(id = "username")
	private WebElement txtUserName;
	
	@FindBy(id = "password")
	private WebElement txtPassword;
	
	@FindBy(css = "button.woocommerce-button:nth-child(4)")
	private WebElement btnLogin;
	
	public void Dismiss() {
		btnDismiss.click();
	}
	
	public void goToMyAccount() {
		btnMyAccount.click();
	}
	
	public void goToLogin(String username, String password) {
		txtUserName.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
	
}
