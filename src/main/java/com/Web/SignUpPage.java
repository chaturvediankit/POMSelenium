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
	@FindBy(xpath="//button[@class='optanon-alert-box-close banner-close-button']")
	WebElement btnCloseCookies;
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
	@FindBy(xpath="//div[@class='col-sm-6']//div[@class='col-xs-12 col-sm-10 custom-dropdown']//span[@class='acn-icon icon-arrow-dropdown']")
	WebElement dropDownCoutry;
	@FindBy(xpath="//span[text()='India']")
	WebElement selectCountry;
	@FindBy(xpath="(//button[@data-id='ddBoxRegistrationStateProvince']/span)[2]")
	WebElement dropDownState;
	//span[contains(text(),'India') and @class='text']
	//a[@data-analytics-link-name='india']/span
	
	@FindBy(id="CareerRegistration_City") 
	WebElement txtCity;
	@FindBy(id="TalentConnectionRegistration_PhoneNumber")
	WebElement txtPhone;
	@FindBy(id="chkJobAlert")
	WebElement chkBoxJobAlert;
	
	public void selectCountry(String countryName) {
		try {
			
		}catch(Exception e) {
			System.out.println("Not able to select Country");
		}
	}
	
	
}
