package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	
	By txtEmail = By.id("Email");
	By txtPassword = By.id("Password");
	By btnLogin = By.className("login-button");
	By btnLogout = By.linkText("Logout");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setEmail(String strEmail) {
		WebElement weEmail = driver.findElement(txtEmail);
		weEmail.clear();
		weEmail.sendKeys(strEmail);
	}
	
	public void setPassword(String strPwd) {
		WebElement wePwd = driver.findElement(txtPassword);
		wePwd.clear();
		wePwd.sendKeys(strPwd);
	}
	
	public void clickOnLogin() {
		driver.findElement(btnLogin).click();
	}
	
	public void clickOnLogout() {
		driver.findElement(btnLogout).click();
	}
}
