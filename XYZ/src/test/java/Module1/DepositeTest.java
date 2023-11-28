package Module1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserFactory.BaseClass;

public class DepositeTest {
	
	WebDriver driver;
	BaseClass Base;
	LoginPage Login;
	HomePage Home;

	@BeforeClass
	public void OpenBrowser() throws InterruptedException {
		Base = new BaseClass();
		driver = Base.OpenChromeBrowser();
	}
	
	@BeforeMethod
	public void LoginUser() throws InterruptedException {
		Login = new LoginPage(driver);
		Login.ClickOnCustomerLogin();
		Thread.sleep(5000);
		Login.SelectUserFromList();
		Thread.sleep(5000);
		Login.Clickonloginbutton();
		
		Home = new HomePage(driver);
		Thread.sleep(5000);
		//Home.VerifyUser();
	}
	
	@Test
	public void DepositeAmount() throws InterruptedException {
		Home.ClickOnDepositeTab();
		Thread.sleep(5000);
		//Home.SetAmount();
		Home.clickOnDeposite();
		Thread.sleep(5000);
		Home.VerifyAmountDepositedOrNot();
	}
	
	@AfterMethod
	public void LogOutUser() {
		Home.ClickOnLogoutButton();
	}
	
	@AfterClass
	public void CloseBrowser() {
		Base.CloseChromeBrowser(driver);
	}
}
