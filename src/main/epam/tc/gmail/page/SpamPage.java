package main.epam.tc.gmail.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpamPage {
	
	private final static Logger LOG = LogManager.getRootLogger();
	private WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(), 'Спам')]")
	private WebElement spamFolderButton;
	
	@FindBy(xpath = "//span[contains(text(), 'Ещё')]")
	private WebElement more;
	
	@FindBy(xpath = "//div[contains(@aria-label, 'Выбрать')]/div/span/div")
	private WebElement choose;
	
	@FindBy(xpath = "//div[@aria-label='В спам!']")
	private WebElement goToSpam;
	
	public SpamPage(WebDriver driver){
		this.driver = driver;
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
		try{
			Thread.sleep(5000);
		}
		catch(IllegalArgumentException | InterruptedException e){
			LOG.info("Some problems with the thread");
		}
		List<WebElement> list = driver.findElements(By.xpath(path));
		if (list.size() != 0){
			return true;
		}
		else
			return false;
	}
		
	public SpamPage goToFolderSpam(){
		wait(more);
		more.click();
			
		wait(spamFolderButton);
		spamFolderButton.click();
		LOG.info("Clicking spam folder");
			
		return this;
	}
	
	public void wait(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
