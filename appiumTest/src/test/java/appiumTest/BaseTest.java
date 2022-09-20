package appiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BaseTest {
     
	public AndroidDriver driver;
	public AppiumDriverLocalService Service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		//code to start the server
		Service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\tahmi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		Service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("pixel_3");
		options.setApp("C:\\Users\\tahmi\\eclipse-workspace\\appiumTest\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		//Android Driver
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	    //Appium code -> Appium server ->  Mobile
		 if(driver!=null){
			    System.out.println("driver does not == null");
			   
			} else {
			    System.out.println("driver == null");
			}
	}
	
	@AfterClass
    public void tearDown()
    {
	     driver.quit();  //stop driver
	     Service.stop(); //code to stop server
			
	}
}
