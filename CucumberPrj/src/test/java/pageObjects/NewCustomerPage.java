package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	WebDriver driver;
	
	@FindBy(xpath="(//ul[@data-widget='treeview']//li[@class='nav-item has-treeview'][3])[1]")
	WebElement wbCustomersMenu;
	
	@FindBy(xpath="//ul[@data-widget='treeview']//li[@class='nav-item has-treeview menu-open']/ul/li[1]")
	WebElement wbCustomersSubmenu;
	
	@FindBy(xpath="//div[@class='float-right']/a")
	WebElement wbAddNewBtn;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement wbEmailTxt;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement wbFNameTxt;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement wbLNameTxt;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement wbSaveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
	WebElement wbSuccessMsg;
	
	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCustomersMenu() {
		wbCustomersMenu.click();
	}
	
	public void clickOnCustomersSubMenu() {
		wbCustomersSubmenu.click();
	}
	
	public void clickOnAddNewBtn() {
		wbAddNewBtn.click();
	}
	
	public void setEmail(String strEmail) {
		wbEmailTxt.sendKeys(strEmail);
	}
	
	public void setFName(String strFName) {
		wbFNameTxt.sendKeys(strFName);
	}
	
	public void setLName(String strLName) {
		wbLNameTxt.sendKeys(strLName);
	}
	
	public void clickOnSaveBtn() {
		wbSaveBtn.click();
	} 
	
	public void verifySuccessMsg(String strMsg) {
		Assert.assertTrue(wbSuccessMsg.getText().contains(strMsg));
	}
}
