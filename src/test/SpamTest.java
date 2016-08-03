package test;

import org.testng.Assert;
import org.testng.annotations.Test;



import main.epam.tc.gmail.pages.HomePage;
import main.epam.tc.gmail.pages.SpamPage;
import main.epam.tc.gmail.pages.StartPage;

public class SpamTest extends BaseTest{
	
  @Test
  public void spam() {
	  StartPage startPage = new StartPage(driver);
	  startPage.login(USER1, PASSWD1);
	  
	  HomePage homePage = new HomePage(driver);
	  homePage.sendMessage(USER2, BODY1);
	  homePage.quit();
	  
	  startPage.login(USER2, PASSWD2);
	  SpamPage spamPage = new SpamPage(driver);
	  spamPage.markAsSpam();
	  homePage.quit();
	  
	  startPage.login(USER1, PASSWD1);
	  homePage.sendMessage(USER2, BODY2);
	  homePage.quit();
	  
	  startPage.login(USER2, PASSWD2);
	  spamPage.goToFolderSpam();
	  Assert.assertEquals(true, spamPage.isInSpam(BODY2));
  }
  
  
}
