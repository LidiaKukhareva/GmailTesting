package main.epam.tc.gmail.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpamPage extends Page{
	
	private final static Logger LOG = LogManager.getRootLogger();
	
	@FindBy(xpath = "//a[contains(text(), 'Spam')]")
	private WebElement spamFolderButton;
	
	@FindBy(xpath = "//span[contains(text(), 'More')]")
	private WebElement more;
	
	@FindBy(xpath = "//div[contains(@aria-label, 'Select')]/div/span/div")
	private WebElement choose;
	
	@FindBy(xpath = "//div[@aria-label='Report spam']")

	private WebElement goToSpam;
	
	public SpamPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public SpamPage markAsSpam(){
		wait(choose);
		choose.click();
		LOG.info("Clicking choose messages");
			
		wait(goToSpam);
		goToSpam.click();
		LOG.info("Clicking go to spam!");	
		return this;
	}
		
	public boolean isInSpam(String whatMessage){
		String path = "//span[contains(text(), '" + whatMessage + "')]";
		List<WebElement> list = driver.findElements(By.xpath(path));
		return (list.size() != 0);
	}
		
	public SpamPage goToFolderSpam(){
		wait(more);
		more.click();
			
		wait(spamFolderButton);
		spamFolderButton.click();
		LOG.info("Clicking spam folder");	
		return this;
	}
	
}
