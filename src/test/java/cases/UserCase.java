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
	public void openBrowser(String browser, String url) {
		driver = Browser.openBrowser(driver, browser, url);
	}

	//注册的用户参数
	@DataProvider(name = "register")
	public Object[][] getData_register() throws IOException {
		//读取注册的参数化文件
		String filepath = "d://parameter/user_register.xlsx";
		Object[][] array = RangeDatabyPOI.poiRangeData(filepath /* sheetname */);
		return array;
	}
	
	//登录的用户参数
	@DataProvider(name = "login")
	public Object[][] getData_login() throws IOException {
		//读取登录的参数化文件
		String filepath = "d://parameter/user_login.xlsx";
		Object[][] array = RangeDatabyPOI.poiRangeData(filepath /* sheetname */);
		return array;
	}

	// 这里多弄几个测试用例来验证登录功能
	@Test(dataProvider = "login")
	public void loginCase(String username, String password)
			throws InterruptedException, FileNotFoundException, IOException {
		// 读取Excel文件中的参数
		User.login(driver, username, password);
	}

	// 这里多弄几个测试用例来验证登录功能
	@Test(dataProvider = "register")
	public void registerCase(String user_name, String user_password, String user_com_passwd,
			String user_email, String user_phone)
			throws InterruptedException, FileNotFoundException, IOException {
		// 读取Excel文件中的参数		
		User.register(driver, user_name, user_password,user_com_passwd,user_email,user_phone);
		
	}

	//@AfterTest
	public void close() {
		Browser.closeBrowser(driver);
	}

}
