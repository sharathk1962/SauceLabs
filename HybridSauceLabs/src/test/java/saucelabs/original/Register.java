package saucelabs.original;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.Homepage;
import resources.BaseGeneric;
import saucelabs.orderplaced.LogintoApplication;

public class Register extends LogintoApplication {
	LogintoApplication lp=new LogintoApplication();
	public WebDriver driver;
	
	@BeforeTest
	public void launchbrowser() throws IOException {
		driver=initialisedriver();
	}
	
//	@Test(priority=6)
	@Test
	public void naigatetosauce() throws IOException, InterruptedException
	{
		//		LogintoApplication lp=new LogintoApplication();
		//		lp.logintosauce("standard_user","secret_sauce");
		//driver=initialisedriver();
	//	lp.launchbrowser();
		lp.logintosauce("standard_user","secret_sauce");
		lp.verifylogin();
		Thread.sleep(4000);
		Homepage hp=new Homepage(driver);
		hp.sidemenuoption().click();
		hp.aboutnavigate().click();
	}


}
