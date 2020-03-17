package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Browser {
	//初始化浏览器 打开
	public static WebDriver openBrowser(WebDriver driver,String browser,String url) {
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "c://geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equals("chrome")) {
			System.setProperty("webdriver.gecko.driver", "c://geckodriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("ie")) {
			System.setProperty("webdriver.gecko.driver", "c://geckodriver.exe");
			driver = new InternetExplorerDriver();
		}else {
			System.err.println("浏览器不正确！！！");
		}
		//浏览器最大化
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
  
	//关闭
	public static void closeBrowser(WebDriver driver) {
		driver.close();
	}
	
	
	
	
	
}
