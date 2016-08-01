package main.epam.tc.gmail.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private final static Logger LOG = LogManager.getRootLogger();
	private WebDriver driver;
	
	@FindBy(xpath = "//div[contains(text(), '��������')]")
	private WebElement writeMessageButton;
	
	@FindBy(xpath = "//textarea[@aria-label='����']")
	private WebElement addressee;
	
	@FindBy(xpath = "//input[@placeholder='����']")
	private WebElement messageTheme;
	
	@FindBy(xpath = "//div[contains(text(), '���������')]")
	private WebElement sendButtom;
	
	@FindBy(xpath = "//a[contains(@title, '������� Google:')]")
	private WebElement buttonU;
	
	@FindBy(xpath = "//a[contains(text(), '�����')]")
	private WebElement quitButton;
	
	@FindBy(xpath = "//a[contains(text(), '��������')]")
	private WebElement incomingMessages;
	
	@FindBy(xpath = "//div[contains(@aria-label, '�������')]/div/span/div")
	private WebElement choose;
	
	@FindBy(xpath = "//div[@role='menuitem' and @selector='unread']")
	private WebElement unread;
	
	@FindBy(xpath = "//div[@aria-label='� ����!']")
	private WebElement goToSpam;
	
	@FindBy(xpath = "//div[@aria-label='���� ������']")
	private WebElement bodyOfMessage;
	
	@FindBy(xpath = "//a[contains(text(), '����')]")
	private WebElement spamFolderButton;
	
	@FindBy(xpath = "//span[contains(text(), '���')]")
	private WebElement more;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public HomePage sendMessage(String user){
		
		wait(writeMessageButton);
		writeMessageButton.click();
		LOG.info("Clicking write message");
		
		wait(addressee);
		addressee.sendKeys(user);
		messageTheme.sendKeys("WWWebdriver try");
		bodyOfMessage.sendKeys("Hello! Let's be friends!");
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
	
	public HomePage markAsSpam(){
		
		wait(choose);
		choose.click();
		LOG.info("Clicking choose messages");
		
		wait(goToSpam);
		goToSpam.click();
		LOG.info("Clicking go to spam!");
		
		return this;
	}
	
	public HomePage goToFolderSpam(){
		wait(more);
		more.click();
		
		wait(spamFolderButton);
		spamFolderButton.click();
		
		return this;
	}
	
	public void wait(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
