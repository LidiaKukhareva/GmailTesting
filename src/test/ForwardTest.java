package test;

import org.testng.annotations.Test;

import main.epam.tc.gmail.pages.ForwardPage;
import main.epam.tc.gmail.pages.StartPage;

public class ForwardTest extends BaseTest{

  @Test
  public void forward() {
	  StartPage startPage = new StartPage(driver);
	  startPage.login(USER2, PASSWD2);
	  ForwardPage forwardPage = new ForwardPage(driver);
	  forwardPage.setForward(USER1);
  }
}
