package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class Login extends BaseTest{
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signUpButton;
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement enterEmailId;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement createEmailId;
	
	
	
	
	public Login() {
		PageFactory.initElements(driver,this);
	}
	
	public void clickLogin() {
		signUpButton.click();
	}
	
	public void enterValidEmailAddress() {
		enterEmailId.sendKeys("te123@test321.com");
		createEmailId.click();
	}
	
	
	
	
	
	
}
