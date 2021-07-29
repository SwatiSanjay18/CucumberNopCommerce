package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;

import org.junit.Assert;
import pageObjects.LoginPage;
import pageObjects.NewCustomerPage;
import utilities.HelperClass;

public class LoginSteps {
	WebDriver driver;
	LoginPage objLoginPage;
	NewCustomerPage objNewCustPage;
	Logger logJ;
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Swati\\AutomationWorkspace\\CucumberPrj\\Drivers\\chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   objLoginPage = new LoginPage(driver);
	   objNewCustPage = new NewCustomerPage(driver);
	   logJ = HelperClass.getLogJ();
	  // PropertiesConfiguration
	}

	@When("User opens URL {string}")
	public void user_opens_url(String strURL) {
		logJ.debug("Opening the application URL");
	    driver.get(strURL);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String strEmail, String strPwd) {
	   logJ.debug("Enter login credentials");
	   objLoginPage.setEmail(strEmail);
	   objLoginPage.setPassword(strPwd);
	}

	@When("Click on login button")
	public void click_on_login_button() {
	   logJ.debug("Click on login button");
	   objLoginPage.clickOnLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String strTitle) {
		logJ.debug("Check if login successful");
	    if(driver.getPageSource().contains("Login was unsuccessful.")) {
	    	driver.close();
	    	Assert.assertTrue(false);	    	
	    }else {
	    	Assert.assertEquals(strTitle, driver.getTitle());
	    }
	}

	@When("User click on Logout link")
	public void user_click_on_logout_link() {
	   logJ.debug("Logout from the application");
	   objLoginPage.clickOnLogout();
	}

	@Then("Close browser")
	public void close_browser() {
		logJ.debug("Closing the browser.");
	    driver.close();
	}
	
	@Then("User clicks on Customers Menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {
		Thread.sleep(2000);
		objNewCustPage.clickOnCustomersMenu();
	}
	
	@Then("User clicks on Customers on SubMenu")
	public void user_clicks_on_customers_on_sub_menu() throws InterruptedException {
		Thread.sleep(2000);
		objNewCustPage.clickOnCustomersSubMenu();
	}
	
	@When("User clicks on Add new button")
	public void user_clicks_on_add_new_button() throws InterruptedException {
		Thread.sleep(2000);
		objNewCustPage.clickOnAddNewBtn();
	}
			
	@Then("Add new customer details")
	public void add_new_customer_details() {
		objNewCustPage.setEmail(HelperClass.genRandomString() + "@nopCommerce.com");
		objNewCustPage.setFName(HelperClass.genRandomString());
		objNewCustPage.setLName(HelperClass.genRandomString());
	}
	
	@When("User click on Save button")
	public void user_click_on_save_button() {
		objNewCustPage.clickOnSaveBtn();
	}
	
	@Then("Page should have {string}")
	public void page_should_have(String strMsg) {
		objNewCustPage.verifySuccessMsg(strMsg);
	}

}
