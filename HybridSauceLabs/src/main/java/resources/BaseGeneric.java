package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseGeneric {
	
	public static WebDriver driver;
	
	public WebDriver initialisedriver() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties" );
				Properties prop=new Properties();
				prop.load(fis);
				String browsername=prop.getProperty("browser");
				String urlvalue=prop.getProperty("url");
				
				if(browsername.equalsIgnoreCase("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
					driver=new ChromeDriver();
					driver.get(urlvalue);
					driver.manage().window().maximize();
					
				}
				
				if(browsername.equalsIgnoreCase("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
					driver=new FirefoxDriver();
					driver.get(urlvalue);
					driver.manage().window().maximize();

					
				}
			//	driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
				return driver;			
		
	}
	
	
}
