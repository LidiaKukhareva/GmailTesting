package main.epam.tc.gmail.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends Page{
	
	private final static Logger LOG = LogManager.getRootLogger();
	
	@FindBy(id = "Email")
	private WebElement username;
	
	@FindBy(id = "Passwd")
	private WebElement password;
	
	@FindBy(id = "next")
	private WebElement nextButton;
	
	@FindBy(id = "signIn")
	private WebElement signInButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Sign in with a different account')]")
	private List<WebElement> anotherAccountButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Add account')]")
	private List<WebElement> addAccountButton;
	
	@FindBy(xpath = "//input[@name='PersistentCookie']")
	private WebElement staySignedIn;
	
	public StartPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public StartPage login(String user, String passwd){	
		wait(username);
		username.sendKeys(user);
		nextButton.submit();
	
		wait(password);	
		password.sendKeys(passwd);
		
		wait(staySignedIn);
		if(staySignedIn.isSelected()){
			staySignedIn.click();
		}
		
		wait(signInButton);
		signInButton.submit();
		LOG.info("Signing in");
		return this;
	}
	
}
