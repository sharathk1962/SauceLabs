package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Yourinfo {

	public WebDriver driver;
	public Yourinfo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="first-name")
	WebElement firstname;

	@FindBy(id="last-name")
	WebElement lastname;

	@FindBy(id="postal-code")
	WebElement postalcode;

	@FindBy(css="input.btn_primary.cart_button")
	WebElement continuetochec;

//	public void enteralldata() {
//		Yourinfo y=new Yourinfo(driver);
//		y.enterfirstname().sendKeys("Sharath");
//		y.enterlastname().sendKeys("Kumar");
//		y.enterzipcode().sendKeys("576102");
//	}
	public WebElement enterfirstname()
	{
		return firstname;
	}

	public WebElement enterlastname()
	{
		return lastname;
	}

	public WebElement enterzipcode()
	{
		return postalcode;
	}

	public WebElement clickoncontinue()
	{
		return continuetochec;
	}
}
