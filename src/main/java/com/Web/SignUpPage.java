package com.Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
WebDriver driver;
	
	//Constructor
	public SignUpPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="CareersRegistration_EmailAddress")
	WebElement txtEmail;
	@FindBy(id="CareersRegistration_Password")
	WebElement txtCreatePassword;
	@FindBy(id="CareersRegistration_RetypePassword") 
	WebElement textConfirmPassword;
	
	@FindBy(id="CareerRegistration_FirstName")
	WebElement txtFirstName;
	@FindBy(id="CareerRegistration_LastName")
	WebElement txtLastName;
	
	//@FindBy(xpath="(//button[@data-id='ddBoxRegistrationCountryRegion'])[2]")
	@FindBy(xpath="//*[@id=\"Form-2d7221ae-8ecd-4205-a525-29930cb60caf\"]/section[1]/div[4]/div[1]/div/div/div[1]/button[1]")
	WebElement dropDownCoutry;
	@FindBy(xpath="(//button[@data-id='ddBoxRegistrationStateProvince']/span)[2]")
	WebElement dropDownState;
	
	@FindBy(id="CareerRegistration_City") 
	WebElement txtCity;
	@FindBy(id="TalentConnectionRegistration_PhoneNumber")
	WebElement txtPhone;
	@FindBy(id="chkJobAlert")
	WebElement chkBoxJobAlert;
	
	
}
