package main.epam.tc.gmail.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	/**
	 * Quite cruel variable definition
	 */
	
	private static WebDriver instance = null;

	/**
	 * Good but change Class name to smth like "WebDriverProvider" or add factory method wich will provide you browserType
	 * Also you can write here driverConfiguration method wich will configure window size and timeouts and simply use it in your BaseTest
	 */

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
