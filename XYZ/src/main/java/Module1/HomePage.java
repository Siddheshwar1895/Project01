package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	@FindBy(xpath = "//span[@class=\"fontBig ng-binding\"]") private WebElement UserName;
	@FindBy(xpath = "//button[@ng-show=\"logout\"]") private WebElement Logout;
	@FindBy(xpath = "//Select[@name=\"accountSelect\"]") private WebElement Accounts;
	@FindBy(xpath = "//button[@ng-click=\"deposit()\"]") private WebElement DepositeTab;
	@FindBy(xpath = "//input[@type=\"number\"]") private WebElement Amount;
	@FindBy(xpath = "//button[@type=\"submit\"]") private WebElement Deposite;
	@FindBy(xpath = "//span[@ng-show=\"message\"]")private WebElement DepositeMsg;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	/*public void VerifyUser() {
		String ActualText = UserName.getText();
		if(ActualText.contains("Harry Potter")) {
			System.out.println("User Is Logged In");
		}else {
			System.out.println("User Is Not Logged In");
		}
	}*/
	
	
	public void VerifyUser(String Username) {
		String ActualText = UserName.getText();
		if(ActualText.contains(Username)) {
			System.out.println("User Is Logged In");
		}else {
			System.out.println("User Is Not Logged In");
		}
	}
	
	public void ClickOnLogoutButton() {
		Logout.click();
	}
	
	/*public void SelectAccount() {
		Select S = new Select(Accounts);
		S.selectByVisibleText("1006");
	}*/
	
	public void SelectAccount(String AccountNo) {
		Select S = new Select(Accounts);
		S.selectByVisibleText(AccountNo);
	}
	
	
	public void ClickOnDepositeTab() {
		DepositeTab.click();
	}
	
	/*public void SetAmount() {
		Amount.sendKeys("1000");
	}*/
	
	
	public void SetAmount(String amount) {
		Amount.sendKeys(amount);
	}
	
	public void clickOnDeposite() {
		Deposite.click();
	}
	
	public String getDepositeMsg() {
		String Text = DepositeMsg.getText();
		return Text;
	}
}
