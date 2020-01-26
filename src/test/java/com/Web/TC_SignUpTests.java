package com.Web;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_SignUpTests {
	WebDriver driver;
	WebDriverObject webDriver=new WebDriverObject();
	FileManager fileManger=new FileManager();
	@BeforeClass
	void setup() throws InterruptedException, IOException {
		driver = webDriver.setup(fileManger.pReader("browser"));
		driver.get(fileManger.pReader("urlSignUP"));
	}
	@Test
	void signUP() {
		SignUpPage sPage = new SignUpPage(driver);
		//driver.findElement(By.xpath("//*[@id=\"body-id\"]/div[1]/div[1]/div/button")).click();
		
		sPage.dropDownCoutry.click();
		sPage.selectCountry.click();
	}
}
