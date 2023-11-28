package BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.PropertyFileReader;

public class BaseClass {

	public WebDriver OpenChromeBrowser() throws InterruptedException {
		PropertyFileReader p = new PropertyFileReader();
		System.setProperty("webdriver.chrome.driver", p.getChromePath());
		WebDriver driver = new ChromeDriver();
		driver.get(p.getUrl());
		driver.manage().window().maximize();
		Thread.sleep(5000);
		return driver;
	}
	
	public void CloseChromeBrowser(WebDriver driver) {
		driver.close();
	}
}