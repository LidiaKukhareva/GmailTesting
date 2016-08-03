package test;

import main.epam.tc.gmail.driverManager.WebDriverProvider;
import main.epam.tc.gmail.propertyProvider.PropertyProvider;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	protected WebDriver driver;
	
	protected PropertyProvider propertyProvider = new PropertyProvider("accountData");

	protected final String USER1 = propertyProvider.getProperty("user1");
	protected final String USER2 = propertyProvider.getProperty("user2");
	protected final String PASSWD1 = propertyProvider.getProperty("passwd1");
	protected final String PASSWD2 = propertyProvider.getProperty("passwd2");
	protected final String BODY1 = propertyProvider.getProperty("body1");
	protected final String BODY2 = propertyProvider.getProperty("body2");
	
  @BeforeClass
  public void atFirst() {
	  driver = WebDriverProvider.getInstance();
	  driver.get("https://www.gmail.com/");
	  WebDriverProvider.configureDriver();
  }
  
  @AfterClass
  public void atLast() {
	  WebDriverProvider.closeDriver();
  }
}
