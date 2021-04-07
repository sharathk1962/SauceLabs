package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpage {

	public WebDriver driver;
	public Checkoutpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div.subheader")
	WebElement titlecheckoutpage;
	
	@FindBy(css="div.summary_info > div:nth-child(7)")
	WebElement totalamount;
	
	@FindBy(css="a.btn_action.cart_button")
	WebElement finishbutton;
	
	@FindBy(css="h2.complete-header")
	WebElement thankyou;
	
	
	public WebElement gettitleofchoutpage()
	{
		return titlecheckoutpage;
	}
	
	public WebElement verifytotal()
	{
		return totalamount;
	}
	
	public WebElement clickonfinish()
	{
		return finishbutton;
	}
	
	public WebElement orderplaced()
	{
		return thankyou;
	}
}
