package main.epam.tc.gmail.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {
	
	private final static Logger LOG = LogManager.getRootLogger();
	private WebDriver driver;
	
	@FindBy(id = "Email")
	private WebElement username;
	
	@FindBy(id = "Passwd")
	private WebElement password;
	
	@FindBy(id = "next")
	private WebElement nextButton;
	
	@FindBy(id = "signIn")
	private WebElement signInButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Войти в другой аккаунт')]")
	private List<WebElement> anotherAccountButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Добавить аккаунт')]")
	private List<WebElement> addAccountButton;
	
	public StartPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public StartPage login(String user, String passwd){
		
		if (anotherAccountButton.size() != 0){
			anotherAccountButton.get(0).click();
			wait(addAccountButton.get(0));
			addAccountButton.get(0).click();
		}
		else{
			if (addAccountButton.size() != 0){
				addAccountButton.get(0).click();
			}		
		}
		wait(username);
		username.sendKeys(user);
		nextButton.submit();
	
		wait(password);	
		password.sendKeys(passwd);
		signInButton.submit();
		LOG.info("Signing in");
		return this;
	}
	
	public void wait(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
