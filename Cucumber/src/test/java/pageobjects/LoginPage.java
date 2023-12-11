package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
	ldriver =rdriver;
	PageFactory.initElements(rdriver,this);
	}
	@FindBy(id="Mailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="//input['login']")
	@CacheLookup
	WebElement linklogin;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement logout;
	
	public void setname(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys("Deva");
	}
	
	public void setpassword() {
		txtpassword.clear();
		txtpassword.sendKeys("upassword");
	}
	
	public void clickLogin() {
		linklogin.click();
	}
	public void clickLogout() {
		logout.click();
	}
}
	


