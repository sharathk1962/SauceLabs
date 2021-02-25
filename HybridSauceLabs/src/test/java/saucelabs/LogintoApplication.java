package saucelabs;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.BaseGeneric;

public class LogintoApplication extends BaseGeneric {
	

	@Test
	public void logintosauce() throws IOException
	{
	driver=initialisedriver();
	}

}
