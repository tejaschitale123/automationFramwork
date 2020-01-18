package qa;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Login;
import pages.Registration;

public class ecommerceTest extends BaseTest {
  Login login;
  Registration registr;
  
	
  @BeforeMethod
  public void setUp() {
	  initialization();
	  login =new Login();
	  registr=new Registration();
  }
	
	
  @Test
  public void login() {
	  registr.selectTShirt();
	  
	  login.clickLogin();
	  login.enterValidEmailAddress();
	  registr.completeRegistrationForm();
  }
}
