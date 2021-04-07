package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class saucehome {
	public WebDriver driver;
	
	public saucehome(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(css="h2.complete-header")
	WebElement thankyou;
	
	
	public WebElement gettitleofchoutpage()
	{
		return thankyou;
	}
	
}
