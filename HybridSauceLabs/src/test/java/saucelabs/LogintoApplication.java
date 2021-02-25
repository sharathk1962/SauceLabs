package saucelabs;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import resources.BaseGeneric;

public class LogintoApplication extends BaseGeneric {
	
	public void logintosauce() throws IOException
	{
		
	driver=initialisedriver();
	}

}
