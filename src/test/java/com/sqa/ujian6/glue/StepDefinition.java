package com.sqa.ujian6.glue;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sqa.ujian6.config.AutomationFrameworkConfiguration;
import com.sqa.ujian6.driver.DriverSingleton;
import com.sqa.ujian6.page.ChartPage;
import com.sqa.ujian6.page.LoginPage;
import com.sqa.ujian6.page.RegisterPage;
import com.sqa.ujian6.utils.ConfigurationProperties;
import com.sqa.ujian6.utils.Constants;
import com.sqa.ujian6.utils.Log;
import com.sqa.ujian6.utils.TestCases;
import com.sqa.ujian6.utils.Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {

	private WebDriver driver;
	private RegisterPage registerPage;
	private LoginPage loginPage;
	private ChartPage chartPage;
	ExtentTest extentTest;
	static ExtentReports report = new ExtentReports("src/main/resources/TestReport.html");
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		registerPage = new RegisterPage();
		loginPage = new LoginPage();
		chartPage = new ChartPage();
		TestCases[] tests = TestCases.values();
		extentTest = report.startTest(tests[Utils.testCount].getTestName());
		Log.getLogData(Log.class.getName()); //log4j
		Log.startTest(tests[Utils.testCount].getTestName()); //log4j
		Utils.testCount++;
	}
	
	// Scenario Register
		@Given("^User go to the Website")
		public void user_go_to_the_Website() {
			driver = DriverSingleton.getDriver();
			driver.get(Constants.URL);
			Log.info("INFO: Navigating to " + Constants.URL); //log4j
			extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
		}
		
		@When("^User click dismiss button")
		public void user_click_dismiss_Button() {
			registerPage.Dismiss();
			extentTest.log(LogStatus.PASS, "User click dismiss button");
		}
		
		@When("^User click my account button")
		public void user_click_my_account_Button() {
			registerPage.goToMyAccount();;
			extentTest.log(LogStatus.PASS, "User click my account button");
		}
		
		@When("^User input username email password and click Register")
		public void user_input_username_password_email_and_click_Register() {
			registerPage.goToRegistration(configurationProperties.getUserName(),configurationProperties.getEmail(), configurationProperties.getPassword());
			extentTest.log(LogStatus.PASS, "User input username email password and click Login");
		}
		
		@Then("^User can register to the Website")
		public void user_can_register_to_the_Website() {
			
			 extentTest.log(LogStatus.PASS, "User can register to the Website");
		}
		
		// Scenario Login
/*		@Given("^User go to the Website")
		public void user_go_to_the_Website() {
			driver = DriverSingleton.getDriver();
			driver.get(Constants.URL);
			Log.info("INFO: Navigating to " + Constants.URL); //log4j
			extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
		}
		
		@When("^User click dismiss button")
		public void user_click_dismiss_Button() {
			loginPage.Dismiss();
			extentTest.log(LogStatus.PASS, "User click dismiss button");
		}
		
		@When("^User click my account button")
		public void user_click_my_account_Button() {
			loginPage.goToMyAccount();
			extentTest.log(LogStatus.PASS, "User click my account button");
		}
		
		@When("^User input username password and click Login")
		public void user_input_username_password_and_click_Login() {
			loginPage.goToLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
			extentTest.log(LogStatus.PASS, "User input username password and click Login");
		}
		
		@Then("^User can login to the Website")
		public void user_can_login_to_the_Website() {
			 
			 extentTest.log(LogStatus.PASS, "User can login to the Website");
		}*/
		
		
		@After
		public void closeObject() {
			report.endTest(extentTest);
			report.flush();
		}
}
