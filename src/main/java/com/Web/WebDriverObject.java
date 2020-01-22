package com.Web;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class WebDriverObject {
    
	public static WebDriver driver;
    //@To setup browser
    
	public WebDriver setup(String browserType) throws InterruptedException, IOException{
	    if(browserType.contains("Chrome")){ 
		launchChromeBrowser();
		}
		else if (browserType.contains("InternetExplorer")) {
			launchIEBrowser();
		}
		else{
			driver = new FirefoxDriver();			
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
		}
	// To launch IE Browser
	void launchIEBrowser(){
			    System.setProperty("webdriver.ie.driver","IEDriverServer3.exe");
				InternetExplorerOptions options = new InternetExplorerOptions();
				options.introduceFlakinessByIgnoringSecurityDomains();
				options.requireWindowFocus();
				driver = new InternetExplorerDriver(options); 
		 }
		
		// To launch Chrome Browser
	void launchChromeBrowser(){
			 System.setProperty("webdriver.chrome.driver","chromedriver1.exe");
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("disable-extensions");
			 options.setExperimentalOption("useAutomationExtension", false);
			 driver = new ChromeDriver(options);
		 }
	
}
