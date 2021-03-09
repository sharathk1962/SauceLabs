package saucelabs;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import resources.BaseGeneric;

public class AddingItemstoCart extends BaseGeneric{
	
	@Test
	public void addingitems() {
	
		Homepage hp=new Homepage(driver);
		hp.addbike_light().click();
		hp.addbolt_Tshirt().click();
	//	JavascriptExecutor js=(JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(30,600)");
		hp.add_allThings().click();
	}


}
