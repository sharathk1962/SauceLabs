package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginbutton;
	
	public WebElement enterusername()
	{
		return username;
	}
	public WebElement enterpassword()
	{
		return password;
	}
	public WebElement clickonlogin()
	{
		return loginbutton;
	}
}
