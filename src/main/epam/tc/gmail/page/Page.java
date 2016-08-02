package main.epam.tc.gmail.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	protected WebDriver driver;

	/**
	 * Empty constructor?
 	 */

	public Page(){}
	
	public Page(WebDriver driver){
		this.driver = driver;
	}

	/**
	 * Move this method to 'Waiter' class and use it from it
	 * Rename in smth like "waitForVisibility"
     */
	
	protected void wait(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
