package main.epam.tc.gmail.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page{
	
	private final static Logger LOG = LogManager.getRootLogger();	
	
	@FindBy(xpath = "//div[contains(text(), 'НАПИСАТЬ')]")
	private WebElement writeMessageButton;
	
	@FindBy(xpath = "//textarea[@aria-label='Кому']")
	private WebElement addressee;
	
	@FindBy(xpath = "//input[@placeholder='Тема']")
	private WebElement messageTheme;
	
	@FindBy(xpath = "//div[contains(text(), 'Отправить')]")
	private WebElement sendButtom;
	
	@FindBy(xpath = "//a[contains(@title, 'Аккаунт Google:')]")
	private WebElement buttonU;
	
	@FindBy(xpath = "//a[contains(text(), 'Выйти')]")
	private WebElement quitButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Входящие')]")
	private WebElement incomingMessages;
	
	@FindBy(xpath = "//div[@aria-label='Тело письма']")
	private WebElement bodyOfMessage;
	
	
	public HomePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public HomePage sendMessage(String user, String body){
		
		wait(writeMessageButton);
		writeMessageButton.click();
		LOG.info("Clicking write message");
		
		wait(addressee);
		addressee.sendKeys(user);
		messageTheme.sendKeys("WWWebdriver try");
		bodyOfMessage.sendKeys(body);
		sendButtom.click();
		LOG.info("Clicking send");
		
		return this;
	}
	
	public HomePage quit(){
		
		wait(buttonU);
		buttonU.click();
		quitButton.click();
		LOG.info("Clicking quit");
		
		return this;
	}
	
}
