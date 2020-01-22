package com.Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "nav-settings__dropdown-trigger")
	WebElement dropDownProfile;
	@FindBy(xpath = "//a[@href='/m/logout/']")
	WebElement linkLogout;
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement linkSignIn;
}
