package Module1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowserFactory.BaseClass;

public class CustomerLoginTest {
	WebDriver driver;
	BaseClass Base;
	LoginPage Login;
	HomePage Home;

	@BeforeClass
	public void OpenBrowser() throws InterruptedException {
		Base  = new BaseClass();
		driver = Base.OpenChromeBrowser();
	}
	
	@Test
	public void loginUser() throws InterruptedException {
		Login = new LoginPage(driver);
		Login.ClickOnCustomerLogin();
		Thread.sleep(5000);
		Login.SelectUserFromList();
		Thread.sleep(5000);
		Login.Clickonloginbutton();
		
		Home = new HomePage(driver);
		Home.VerifyUser();
		Home.ClickOnLogoutButton();
	}
	
	@AfterClass
	public void closeBrowser() {
		Base.CloseChromeBrowser(driver);
	}
}
