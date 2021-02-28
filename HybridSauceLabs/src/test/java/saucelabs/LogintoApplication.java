package saucelabs;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LoginPage;
import resources.BaseGeneric;

public class LogintoApplication extends BaseGeneric {

	@Test(dataProvider="getusernamepassword")
	public void logintosauce(String username, String Pasword) throws IOException
	{

		driver=initialisedriver();
		LoginPage lp=new LoginPage(driver);
		lp.enterusername().sendKeys(username);
		lp.enterpassword().sendKeys(Pasword);
		lp.clickonlogin().click();

		//to get username password from webpage
//		List<WebElement> names = driver.findElements(By.xpath("//div[@id='login_credentials']"));
//		for(int i=0;i<names.size();i++) {
//			String usernames=names.get(i).getText();
//			System.out.println("user index " +i+ " names are" +names.get(i).getText());
//		} 


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

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
