package saucelabs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import resources.BaseGeneric;

public class AddingItemstoCart extends BaseGeneric{
	
	public static Logger log=LogManager.getLogger(AddingItemstoCart.class.getName());
	
	@Test
	public void addingitems() {
	
		Homepage hp=new Homepage(driver);
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


}
