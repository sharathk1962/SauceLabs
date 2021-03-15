package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(css="span.fa-layers-counter.shopping_cart_badge")
	WebElement noofitems;
	
	@FindBy(tagName="svg")
	WebElement cartitems;
	
	@FindBy(css="select.product_sort_container")
	WebElement sortingproduct;

	@FindBy(xpath="//div[@id='inventory_container']/div/div[1]/div[3]")
	WebElement firstitemprice;
	
	
	public WebElement homepagevalidation()
	{
		return productlabel;
	}
	
	public WebElement addbike_light()
	{
	//	driver.get(driver.getCurrentUrl());
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
	
	public WebElement cartnoofitem()
	{
		return noofitems;
	}
	
	public WebElement cartbutton()
	{
		return cartitems;
	}
	
	public WebElement sortproduct()
	{
		Select s=new Select(sortingproduct);
		s.selectByValue("lohi");
		return sortingproduct;
	}
	
	public WebElement sorttooriginal()
	{
		Select s=new Select(sortingproduct);
		s.selectByValue("az");
	//	s.selectByVisibleText("Name (A to Z)");
		return sortingproduct;
	}
	
	public WebElement firstprice()
	{
		//String price=seconditemprice.getText();
		return firstitemprice;
	}


}
