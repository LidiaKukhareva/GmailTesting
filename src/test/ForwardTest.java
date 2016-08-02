package test;

import org.testng.annotations.Test;

import main.epam.tc.gmail.page.ForwardPage;
import main.epam.tc.gmail.page.StartPage;

public class ForwardTest extends BaseTest{
  @Test
  public void forward() {
	  StartPage startPage = new StartPage(driver);
	  startPage.login(user2, passwd2);
	  ForwardPage forwPage = new ForwardPage(driver);
	  forwPage.setForward(user1);
  }
}
