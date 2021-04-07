package saucelabs.orderplaced;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import pageobjects.Cart;
import pageobjects.Checkoutpage;
import pageobjects.Yourinfo;
import resources.BaseGeneric;

public class RemoveandCheckout extends BaseGeneric{

//	public WebDriver driver;
	public static Logger log=LogManager.getLogger(RemoveandCheckout.class.getName());
	Checkoutpage cp;
	//@Test(priority=3)
	@Test
	public void removefromcart()
	{
		Cart c=new Cart(driver);
		//		WebDriverWait w=new WebDriverWait(driver,10);
		//		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Your Cart')]")));
		c.removeRedshirt().click();
		log.info("All thinsg Red Tshirt removed succesfully");
		c.clickoncheckout().click();	
	}

	//@Test(priority=4)
	@Test
	public void fillandcontinue()
	{
		Yourinfo y=new Yourinfo(driver);
		y.enterfirstname().sendKeys("Sharath");
		y.enterlastname().sendKeys("Kumar");
		y.enterzipcode().sendKeys("576102");
//		y.enteralldata();
		y.clickoncontinue().click();
		log.debug("all the information filled and navigating to checkout page");
		cp=new Checkoutpage(driver);
		String titlechkpage=cp.gettitleofchoutpage().getText();
		Assert.assertEquals(titlechkpage, "Checkout: Overview","checkout page is not loaded");
		
	}
	
//	@Test(priority=5)
	@Test
	public void verifyamountandFinish()
	{
		Assert.assertEquals(cp.verifytotal().getText(),"Total: $28.06");	
		cp.clickonfinish().click();
		Assert.assertEquals(cp.orderplaced().getText(),"THANK YOU FOR YOUR ORDER");	

	}

}
