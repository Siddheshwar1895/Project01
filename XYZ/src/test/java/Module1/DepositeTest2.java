package Module1;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BrowserFactory.BaseClass;
import Utility.ExcelReader;
import Utility.Screenshot;

public class DepositeTest2 {
	
	WebDriver driver;
	BaseClass Base;
	LoginPage Login;
	HomePage Home;
	String Tcid;

	@BeforeClass
	public void OpenBrowser() throws InterruptedException {
		Base = new BaseClass();
		driver = Base.OpenChromeBrowser();
	}
	
	@BeforeMethod
	public void LoginUser() throws InterruptedException {
		Login = new LoginPage(driver);
		Login.ClickOnHomeButton();
		Login.ClickOnCustomerLogin();
		Thread.sleep(5000);
		Login.SelectUserFromList();
		Thread.sleep(5000);
		Login.Clickonloginbutton();
	}
	
	@DataProvider
	public Object[][] getTestData() throws EncryptedDocumentException, IOException {
		ExcelReader E = new ExcelReader();
		 Object[][] data = E.getData();
		 return data;
		 //{"101","HarryPotter","1005","3000"}
	}
	
	
	@Test (dataProvider = "getTestData")
	public void DepositeAmount(String TCID, String Username,String AccountNo,String amount) throws InterruptedException {
		try{
			Tcid = TCID;
		Home = new HomePage(driver);
		Thread.sleep(5000);
		Home.VerifyUser(Username);//"Harry Potter"
		Home.SelectAccount(AccountNo);//"1005"
		Thread.sleep(5000);
		Home.ClickOnDepositeTab();
		Thread.sleep(5000);
		Home.SetAmount(amount);//"3000"
		Thread.sleep(5000);
		Home.clickOnDeposite();
		Thread.sleep(5000);
		String ActualText = Home.getDepositeMsg();
		String ExpectedText = "Deposit Successful";
		Assert.assertEquals(ActualText, ExpectedText);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void LogOutUser(ITestResult result) throws InterruptedException, IOException {
		Screenshot Screen = new Screenshot();
		if(ITestResult.FAILURE==result.getStatus()) {
			Screen.TakeAScreenshot(driver, Tcid);
		}
		Home.ClickOnLogoutButton();
		Thread.sleep(5000);
	}
	
	@AfterClass
	public void CloseBrowser() {
		Base.CloseChromeBrowser(driver);
	}
}
