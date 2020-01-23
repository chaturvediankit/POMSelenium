package com.Web;

import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
public class TC_LoginTestCases {
	WebDriver driver;
	WebDriverObject webDriver=new WebDriverObject();
	FileManager fileManger=new FileManager();
	@BeforeClass
	void setup() throws InterruptedException, IOException {
		driver = webDriver.setup(fileManger.pReader("browser"));
	}
	@Test
	void loginWithValidCredentials() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		try {
			driver.get(fileManger.pReader("URL"));
			loginPage.loginApplication(fileManger.pReader("username"), fileManger.pReader("passwordDev"));
			//rf.AssertElementIsPresent(homePage.linkDashboard);
		} catch (Exception e) {
			//boolean invalidUser = rf.IsElementPresent(loginPage.loginError);
			//if (invalidUser)
			//	Reporter.log("Invalid credentials" + loginPage.loginError.getText());
			//else
				Reporter.log(
						"Either url is not working or assert identifier is not correct and please refer screen shot for same.");
		}
	}
	@AfterClass
	void tearDown() {
		driver.close();

	}
}
