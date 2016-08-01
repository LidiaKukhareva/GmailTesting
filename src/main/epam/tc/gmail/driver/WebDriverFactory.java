package main.epam.tc.gmail.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	
	private static WebDriver instance = null;
	
	private WebDriverFactory() {}
	
	public static WebDriver getInstance(){
		if(instance == null){
			instance = new FirefoxDriver();
		}
		return instance;
	}
	
	public static void closeDriver(){
		instance.quit();
		instance = null;
	}
}
