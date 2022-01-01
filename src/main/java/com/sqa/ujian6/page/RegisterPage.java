package com.sqa.ujian6.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sqa.ujian6.driver.DriverSingleton;

public class RegisterPage {

	private WebDriver driver;
	
	public RegisterPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".woocommerce-store-notice__dismiss-link")
	private WebElement btnDismiss;
	
	@FindBy(css = ".pull-right > li:nth-child(2) > a:nth-child(1)")
	private WebElement btnMyAccount;
	
	@FindBy(id = "reg_username")
	private WebElement txtUserName;
	
	@FindBy(id = "reg_email")
	private WebElement txtEmail;
	
	@FindBy(id = "reg_password")
	private WebElement txtPassword;
	
	@FindBy(css =".woocommerce-Button")
	private WebElement btnRegister;
	
	public void Dismiss() {
		btnDismiss.click();
	}
	
	public void goToMyAccount() {
		btnMyAccount.click();
	}
	
	public void goToRegistration(String username, String email, String password) {
		txtUserName.sendKeys(username);
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnRegister.click();
	}
}
