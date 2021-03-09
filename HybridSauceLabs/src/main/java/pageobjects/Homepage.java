package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.BaseGeneric;

public class Homepage  {
	
	public WebDriver driver;
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div.product_label")
	WebElement productlabel;
	
	@FindBy(xpath="//div[@id=\"inventory_container\"]/div/div[2]/div[3]/button")
	WebElement Bike_Light;
	
	@FindBy(xpath="//div[@id='inventory_container']/div/div[3]/div[3]/button")
	WebElement Bolt_Tshirt;
	
	@FindBy(xpath="//div[@id='inventory_container']/div/div[6]/div[3]/button")
	WebElement all_Things;
	

	public WebElement homepagevalidation()
	{
		return productlabel;
	}
	
	public WebElement addbike_light()
	{
		return Bike_Light;
	}
	
	public WebElement addbolt_Tshirt()
	{
		return Bolt_Tshirt;
	}
	
	public WebElement add_allThings()
	{
		return all_Things;
	}
}
