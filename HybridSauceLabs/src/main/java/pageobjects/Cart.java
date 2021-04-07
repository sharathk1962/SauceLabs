package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {

	public WebDriver driver;

	public Cart(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#cart_contents_container > div > div.cart_list > div:nth-child(5) > div.cart_item_label > div.item_pricebar > button")
	private WebElement Allredshirt;
	
	@FindBy(css="a.btn_action.checkout_button")
	WebElement checkout;

	public WebElement removeRedshirt() {
		return Allredshirt;
	}

	public WebElement clickoncheckout() {
		return checkout;
	}

}
