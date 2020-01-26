package com.Web;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class WebDriverHelper {
	public void clickUsingJS(WebDriver driver,WebElement clickElement) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", clickElement);
		
	}
	public void scrollIntoView(WebDriver driver,WebElement viewElement) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", viewElement); 
	}
	public void typeText(WebElement txtElement, String text) {
		
		txtElement.clear();
		txtElement.sendKeys(text);
	}
	
	public String GetCurrentDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String CurrentDate = dateFormat.format(date); 
		return CurrentDate; 
	}
	
	public String GetCurrentDateTime(){
		DateFormat dateTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String CurrentDate = dateTimeFormat.format(date); 
		return CurrentDate; 
	}
	 //This method is to capture the screenshot and return the path of the screenshot.
	public static String getScreenshot(WebDriver driver, String screenshotName) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "\\TestScreenshots\\" + screenshotName + dateName + ".png"; 
		try{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
		}
		catch (Exception e){
			//TODO: print in log file: e.printstackTrace();
		}
		return destination;
	}
	public void selectdropDownByVisibleText(WebElement element, String val) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(val);			
		} catch (Exception e) {
			//Take Screenshots
		}
	}

	public void selectdropDownByVal(WebElement element, String val) {
		Select select = new Select(element);
		select.selectByValue(val);
	}

	public void selectdropDownByIndex(WebElement element, Integer index) {
		Select select = new Select(element);
	    select.selectByIndex(index);
	}
	public void selectCheckBox(WebElement chkBox)
	{
		try
		{
			if (!chkBox.isSelected()) chkBox.click();
		}
		catch(Exception e)
		{
			WebDriverHelper.getScreenshot(WebDriverObject.driver, "SelectCheckBox");
		}
		
	}
	public void mouseHover(WebElement hover, String callingFnName)
	{
		try{
			Actions action = new Actions(WebDriverObject.driver);
			action.moveToElement(hover).build().perform();
		}catch (Exception e){
			
		}
		
	}
	public String getText(WebElement element) {
		String text = null;
		try {
			text=element.getText();
		}catch(Exception e) {
			
		}		
	return text;
		
	}
	public String getTextByAtrribute(WebElement element) {
		String text = null;
		try {
			text=element.getAttribute("value");
		}catch(Exception e) {
			
		}		
	return text;
		
	}

	public String GetCurrentWindow()
    {
        return WebDriverObject.driver.getWindowHandle();
    }
	
	public void SwitchToCurrentWindow(String currentWindow)
    {
		WebDriverObject.driver.close();
        WebDriverObject.driver.switchTo().window(currentWindow);
    }
	
	public void SwitchToWindow()
    {
		String windowHandle =  WebDriverObject.driver.getWindowHandle();
        WebDriverObject.driver.switchTo().window(windowHandle);
    }
	public void switchToNewTab()
	{
		ArrayList<String> tabs2 = new ArrayList<String> (WebDriverObject.driver.getWindowHandles());
		WebDriverObject.driver.switchTo().window(tabs2.get(1));
	}
	public void acceptAlert( WebDriver driver)
	{
		try
		{
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}
		catch(Exception e)
		{
			}
	}

}
