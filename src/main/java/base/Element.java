package base;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.ReadProperties;

public class Element {
	
	//WebDriver driver;
	static WebElement element;

	//定位页面元素
	public  static WebElement element(WebDriver driver,String key,String value) throws FileNotFoundException, IOException {
		
		//String key_value= ReadProperties.getprop("loginElement", "username");
		if(key.equals("id")) {
			element = driver.findElement(By.id(value));
		}else if(key.equals("name")) {
			element = driver.findElement(By.name(value));
		}else if(key.equals("classname")) {
			element = driver.findElement(By.className(value));
		}else if(key.equals("tagname")) {
			element = driver.findElement(By.tagName(value));
		}else if(key.equals("linktext")) {
			element = driver.findElement(By.linkText(value));
		}else if(key.equals("partiallinktext")) {
			element = driver.findElement(By.partialLinkText(value));
		}else if(key.equals("xpath")) {
			element = driver.findElement(By.xpath(value));
		}else if(key.equals("cssselector")) {
			element = driver.findElement(By.cssSelector(value));
		}else {
			System.err.println("未能找到元素！");
		}
		
		return element;
	}
	
}
