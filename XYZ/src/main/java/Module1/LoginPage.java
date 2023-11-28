package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.PropertyFileReader;

public class LoginPage  {
	
	@FindBy(xpath = "//button[@class=\"btn home\"]") private WebElement Home;
	@FindBy(xpath = "//button[@ng-click=\"customer()\"]") private WebElement CustomerLogin;
	@FindBy(xpath = "//button[@ng-click=\"manager()\"]") private WebElement BankLogin;
	@FindBy(xpath = "//select[@name=\"userSelect\"]")private WebElement UserList;
	@FindBy(xpath = "//button[@type=\"submit\"]")private WebElement LoginButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		//Use to be convert @FindBy to driver.findelements
	}
	PropertyFileReader p = new PropertyFileReader();
	
	public void ClickOnHomeButton() {
		Home.click();
	}

	public void ClickOnCustomerLogin() {
		CustomerLogin.click();
	}
	
	public void ClickBankLogin() {
		BankLogin.click();
	}
	
	public void SelectUserFromList() {
		Select S = new Select(UserList);
		S.selectByVisibleText(p.getUserName());
	}
	
	public void Clickonloginbutton() {
		LoginButton.click();
	}
}
