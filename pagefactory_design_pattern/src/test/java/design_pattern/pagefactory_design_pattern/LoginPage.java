package design_pattern.pagefactory_design_pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	public WebDriver driver;

	// Constructor...
	LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// find element by findBy...
	@FindBy(xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[1]/img")
	WebElement check_Logo_text;
	@FindBy(xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	WebElement name_field;
	@FindBy(xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	WebElement password_field;
	@FindBy(xpath = "//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement clk_btn;
	
	// Action Method...
	public void setname(String username) {
		name_field.sendKeys(username);
	}
	public void setpassword(String password) {
		password_field.sendKeys(password);
	}
	public void click_login_btn() {
		clk_btn.click();
	}
	public void check_Logo() {
		//return check_Logo.isDisplayed();
		try {
		Assert.assertEquals(check_Logo_text,true);
		}catch(Exception r) {
			r.printStackTrace();
		}
}
}
