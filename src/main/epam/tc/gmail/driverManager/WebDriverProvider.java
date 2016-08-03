package main.epam.tc.gmail.driverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverProvider {
	
	private static WebDriver driver = null;

	private WebDriverProvider() {}
	
	public static WebDriver getInstance(){
		if(driver == null){
			String whatBrowser = System.getProperty("browserType");
			driver = provideWithBrowser(BrowserType.valueOf(whatBrowser.toUpperCase()));
		}
		return driver;
	}
	
	public static void closeDriver(){
		driver.quit();
		driver = null;
	}
	
	public static void configureDriver(){
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public static WebDriver provideWithBrowser(BrowserType whatBrowser){
		switch(whatBrowser){
		case CHROME:
			return new ChromeDriver();
		case FIREFOX:
			return new FirefoxDriver();
		case EXPLORER:
			return new InternetExplorerDriver();
		default:
			return new FirefoxDriver();
		}
	}
}
