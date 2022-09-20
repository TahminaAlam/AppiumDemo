package appiumTest;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class InheritTest {

		public AndroidDriver driver;
		public AppiumDriverLocalService Service;
		
		@BeforeClass
		public void ConfigureAppium() throws MalformedURLException
		{
			//start server
			Service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\tahmi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
			Service.start();
			//desireCapabilities
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("pixel_3");
			options.setApp("C:\\Users\\tahmi\\eclipse-workspace\\appiumTest\\src\\test\\java\\resources\\General-Store.apk");
			//Android Driver
			 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		 public double getFormatedAmount(String amount)
	      {
	      	Double price = Double.parseDouble(amount.substring(1));
	      	return price;
	      }
		
		@AfterClass
	    public void tearDown()
	    {
		     driver.quit();  //stop driver
		     Service.stop(); //code to stop server
				
		}
	
}