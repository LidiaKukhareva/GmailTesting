package test;

import org.testng.annotations.Test;

import junit.framework.Assert;
import main.epam.tc.gmail.page.HomePage;
import main.epam.tc.gmail.page.SpamPage;
import main.epam.tc.gmail.page.StartPage;

public class SpamTest extends BaseTest{
	
  @Test
  public void spam() {
	  StartPage startPage = new StartPage(driver);
	  startPage.login(user1, passwd1);
	  
	  HomePage homePage = new HomePage(driver);
	  homePage.sendMessage(user2, body1);
	  homePage.quit();
	  
	  startPage.login(user2, passwd2);
	  SpamPage spamPage = new SpamPage(driver);
	  spamPage.markAsSpam();
	  homePage.quit();
	  
	  startPage.login(user1, passwd1);
	  homePage.sendMessage(user2, body2);
	  homePage.quit();
	  
	  startPage.login(user2, passwd2);
	  spamPage.goToFolderSpam();
	  Assert.assertEquals(true, spamPage.isInSpam(body2));
  }
  
  
}