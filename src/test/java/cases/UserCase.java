package cases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import tasks.User;
import util.Browser;
import util.RangeDatabyPOI;

public class UserCase {
	
	WebDriver driver;	
	
	@Parameters({ "browser", "url" })
	@BeforeTest
	public void openBrowser(String browser,String url) {
		driver =  Browser.openBrowser(driver,browser,url);
	}
	
	@DataProvider(name = "login")
	public Object[][] getData() throws IOException{		
		String filepath = "d://user.xlsx";
		Object[][] array = RangeDatabyPOI.poiRangeData(filepath /*sheetname*/);		
		return array;
	}
	
	//这里多弄几个测试用例来验证登录功能	
	@Test(dataProvider = "login")
	public void loginCase(String username,String password) throws InterruptedException, FileNotFoundException, IOException {
		//读取Excel文件中的参数
		User.login(driver, username, password);		
		
	}		
	
	@AfterTest
	public void close() {
		Browser.closeBrowser(driver);
	}

}
