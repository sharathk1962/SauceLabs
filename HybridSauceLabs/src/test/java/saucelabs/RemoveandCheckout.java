package saucelabs;

import org.testng.annotations.Test;
import org.apache.logging.log4j.*;

import pageobjects.Cart;
import pageobjects.Yourinfo;
import resources.BaseGeneric;

public class RemoveandCheckout extends BaseGeneric{

	public static Logger log=LogManager.getLogger(RemoveandCheckout.class.getName());
	
	@Test(priority=3)
	public void removefromcart()
	{
		Cart c=new Cart(driver);
		//		WebDriverWait w=new WebDriverWait(driver,10);
		//		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Your Cart')]")));
		c.removeRedshirt().click();
		log.info("All thinsg Red Tshirt removed succesfully");
		c.clickoncheckout().click();	
	}

	@Test(priority=4)
	public void fillandcontinue()
	{
		Yourinfo y=new Yourinfo(driver);
		y.enterfirstname().sendKeys("Sharath");
		y.enterlastname().sendKeys("Kumar");
		y.enterzipcode().sendKeys("576102");
//		y.enteralldata();
		y.clickoncontinue().click();
	}

}
