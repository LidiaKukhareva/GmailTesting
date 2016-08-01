package test;

import org.testng.annotations.Test;

import main.epam.tc.gmail.page.HomePage;
import main.epam.tc.gmail.page.StartPage;

public class GmailTest extends BaseTest{
	
  @Test
  public void spam() {
	  StartPage sp = new StartPage(driver);
	  sp.login(user1, passwd1);
	  HomePage hp = new HomePage(driver);
	  hp.sendMessage(user2);
	  hp.quit();
	  sp.login(user2, passwd2);
	  hp.markAsSpam();
	  hp.quit();
	  sp.login(user1, passwd1);
	  hp.sendMessage(user2);
	  hp.quit();
	  sp.login(user2, passwd2);
	  hp.goToFolderSpam();
  }
  
  
}
