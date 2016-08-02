package main.epam.tc.gmail.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForwardPage extends Page{
	
	private final static Logger LOG = LogManager.getRootLogger();
	
	@FindBy(xpath = "//div[@aria-label='Настройки' and @data-tooltip='Настройки']")
	private WebElement settingsButton;
	
	@FindBy(xpath = "//div[contains(text(), 'Настройки')]")
	private WebElement chooseSettingsButton;
	
	@FindBy(xpath = "//a[contains(text(), POP/IMAP)]")
	private WebElement ForwardingPOPIMap;
	
	public ForwardPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public ForwardPage setForward(String user){
		wait(settingsButton);
		settingsButton.click();
		LOG.info("Clicking settings");
		
		wait(chooseSettingsButton);
		chooseSettingsButton.click();
		LOG.info("Choose settings");
		
		wait(ForwardingPOPIMap);
		ForwardingPOPIMap.click();
		LOG.info("Clicking forwarding and POP/IMAP");
		return this;
	}
	
}
