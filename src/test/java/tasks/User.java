package tasks;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.ReadProperties;

public class User {

	// 注册
	public static void register(WebDriver driver, String user_name, String user_password, String user_com_passwd,
			String user_email, String user_phone) throws FileNotFoundException, IOException, InterruptedException {
		// 从首页进入到注册页 要读取配置文件
		// 数据校验并输入参数值
		//考虑两点 1.如果是已经注册成功的会员，再次注册会失败，判断失败后，要清空输入框 2.注册成功后，要退出登录，继续执行参数化注册
		driver.findElement(By.xpath(ReadProperties.getprop("userElement", "elements", "site-topbar_register"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(ReadProperties.getprop("userElement", "elements", "user_name")))
				.sendKeys(user_name);
		driver.findElement(By.xpath(ReadProperties.getprop("userElement", "elements", "user_password")))
				.sendKeys(user_password);
		driver.findElement(By.xpath(ReadProperties.getprop("userElement", "elements", "user_com_passwd")))
				.sendKeys(user_com_passwd);
		driver.findElement(By.xpath(ReadProperties.getprop("userElement", "elements", "user_email")))
				.sendKeys(user_email);
		driver.findElement(By.xpath(ReadProperties.getprop("userElement", "elements", "user_phone")))
				.sendKeys(user_phone);
		driver.findElement(By.xpath(ReadProperties.getprop("userElement", "elements", "agreement"))).click();
		driver.findElement(By.xpath(ReadProperties.getprop("userElement", "elements", "user_register_form_button")))
				.click();
		Thread.sleep(3000);
	}

	// 登录
	public static void login(WebDriver driver, String username, String passwrod)
			throws InterruptedException, FileNotFoundException, IOException {
		// 从首页进入到注册页 要读取配置文件
		// 数据校验并输入参数值
		driver.findElement(By.xpath(ReadProperties.getprop("userElement", "elements", "site-topbar_login"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(ReadProperties.getprop("userElement", "elements", "username"))).sendKeys(username);
		driver.findElement(By.xpath(ReadProperties.getprop("userElement", "elements", "password"))).sendKeys(passwrod);
		driver.findElement(By.xpath(ReadProperties.getprop("userElement", "elements", "button"))).click();
		Thread.sleep(3000);
	}

	// 找回密码
	public void backPassword() {

	}

}
