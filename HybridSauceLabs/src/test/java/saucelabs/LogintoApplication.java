package saucelabs;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Homepage;
import pageobjects.LoginPage;
import resources.BaseGeneric;

public class LogintoApplication extends BaseGeneric {
	
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(LogintoApplication.class.getName());

	@BeforeTest
	public void launchbrowser() throws IOException {
		driver=initialisedriver();
	}

	@Test(dataProvider="getusernamepassword")
	public void logintosauce(String username, String Pasword) throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.enterusername().sendKeys(username);
		lp.enterpassword().sendKeys(Pasword);
		lp.clickonlogin().click();
		log.info("login to applictaion as " +username+ " succesfully" );

		//to get username password from webpage
		//		List<WebElement> names = driver.findElements(By.xpath("//div[@id='login_credentials']"));
		//		for(int i=0;i<names.size();i++) {
		//			String usernames=names.get(i).getText();
		//			System.out.println("user index " +i+ " names are" +names.get(i).getText());
		//		} 
	}

	@Test
	public void verifylogin() {
		Homepage hp=new Homepage(driver);
		String actual=	hp.homepagevalidation().getText();
		Assert.assertEquals(actual,"Products");
		log.info("I am on the home page of the saucedemo website" );
	}

	@Test(enabled=false)
	public void autowebdriverdependencies()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.quit();
	}


	@DataProvider()
	public Object[][] getusernamepassword()
	{
		Object object[][] =new Object[1][2];
		object[0][0]="standard_user";
		object[0][1]="secret_sauce";
		//		object[1][0]="locked_out_user";
		//		object[1][1]="secret_sauce";
		return object;
	}

//	@AfterTest
//	public void teardown()
//	{
//		driver.quit();
//	}

}
