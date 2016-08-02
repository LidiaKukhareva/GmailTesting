package test;

import main.epam.tc.gmail.account.AccountAttribute;
import main.epam.tc.gmail.account.AccountDataProvider;
import main.epam.tc.gmail.driver.WebDriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	protected WebDriver driver;
	
	protected AccountDataProvider bundle = AccountDataProvider.getInstance();;
	/**
	 * final variables should be defined in UPPER CASE
	 */

	protected final String user1 = bundle.getValue(AccountAttribute.USER1);
	protected final String user2 = bundle.getValue(AccountAttribute.USER2);
	protected final String passwd1 = bundle.getValue(AccountAttribute.PASSWD1);
	protected final String passwd2 = bundle.getValue(AccountAttribute.PASSWD2);
	protected final String body1 = bundle.getValue(AccountAttribute.BODY1);
	protected final String body2 = bundle.getValue(AccountAttribute.BODY2);
	
  @BeforeClass
  public void atFirst() {
	  driver = WebDriverFactory.getInstance();
	  driver.get("https://www.gmail.com/");
	  driver.manage().window().maximize(); 
  }
  
  @AfterClass
  public void atLast() {
	  WebDriverFactory.closeDriver();
  }
}
