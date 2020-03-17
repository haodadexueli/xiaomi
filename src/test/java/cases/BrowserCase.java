package cases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import util.Browser;

public class BrowserCase {
	
	WebDriver driver;	
	//打开浏览器
	@Parameters({ "browser", "url" })	
	@BeforeTest
	public  void openBrowser(String browser,String url) {
		driver =  Browser.openBrowser(driver,browser,url);		
	}
	
	
	@AfterTest
	public void closeBrowser() {
		Browser.closeBrowser(driver);
	}
	
}
