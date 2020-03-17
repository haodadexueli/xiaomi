package tasks;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.ReadProperties;

public class User {
	
	//注册
	public void register() {
		
	}
	
	//登录
	public static void login(WebDriver driver,String username,String passwrod) throws InterruptedException, FileNotFoundException, IOException {
		//定位用户名和密码
		//从首页进入到登录页  要读取配置文件		
		driver.findElement(By.xpath(ReadProperties.getprop("loginElement","elements","indexbutton"))).click();			
		Thread.sleep(3000);
		driver.findElement(By.id(ReadProperties.getprop("loginElement","elements","username"))).sendKeys(username);
		driver.findElement(By.id(ReadProperties.getprop("loginElement","elements","password"))).sendKeys(passwrod);
		driver.findElement(By.xpath(ReadProperties.getprop("loginElement","elements","button"))).click();
		Thread.sleep(3000);
	}
	
	//找回密码
	public void backPassword() {
		
	}
	

}
