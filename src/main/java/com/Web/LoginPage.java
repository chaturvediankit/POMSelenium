package com.Web;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	//Constructor
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Login page Objects
	@FindBy(id="username") WebElement txtUsername;
	@FindBy(id="password") WebElement txtPassword;
	@FindBy(xpath="//button[@aria-label='Sign in']") WebElement btnSignIn;
	@FindBy(id="join_now") WebElement linkJoinNow;
	@FindBy(xpath="//a[contains(text(),'Forgot password?')]") WebElement forgotPasswordLink;
	@FindBy(xpath="//div[@id='error-for-password' and @error-for='password']")
	WebElement errorPassword;
		
	//To login into application		
	public void loginApplication(String usernameValue, String passwordValue) throws InterruptedException, IOException{
		txtUsername.clear();
		txtUsername.sendKeys(usernameValue);
		txtPassword.clear();
		txtPassword.sendKeys(passwordValue);
		btnSignIn.click();
		 }
	}
