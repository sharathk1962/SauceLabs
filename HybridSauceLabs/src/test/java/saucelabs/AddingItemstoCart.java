package saucelabs;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Homepage;
import resources.BaseGeneric;
import resources.ExtentReporter;

public class AddingItemstoCart extends BaseGeneric{
	
	public static Logger log=LogManager.getLogger(AddingItemstoCart.class.getName());
	
	Homepage hp;
	
	@Test(priority=2)
	public void addingitems() throws InterruptedException {
		hp.addbike_light().click();
		hp.addbolt_Tshirt().click();
	//	JavascriptExecutor js=(JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(30,600)");
		hp.add_allThings().click();
		String itemcount=hp.cartnoofitem().getText();
		int count=Integer.parseInt(itemcount);
		if(count==3) {
			log.info("all the " +count+ " added succesfully to the cart");
		}
		else
		log.error("cart added only " +count+  " items where as it should have been added 3 items");	
		hp.cartbutton().click();
	}
	
	@Test(priority=1)
	public void sortingitems() throws IOException
	{
	hp=new Homepage(driver);
	hp.sortproduct().click();
	hp.sorttooriginal().click();   //because of this validation failed and purposely did
	String p=hp.firstprice().getText();
	String s=p.substring(0,5);
	System.out.println(s);
	Assert.assertEquals(s,"$7.99");
	hp.sorttooriginal().click(); 
	}
}
