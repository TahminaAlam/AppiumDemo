package appiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class mobileBrowserTest {

	@Test
	public <ChromeDriverService> void Browsertest() throws MalformedURLException, InterruptedException
	{
		
		//code to start the server
		AppiumDriverLocalService Service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\tahmi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		Service.start();
		
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("tahmi");
        options.setChromedriverExecutable("C:\\Users\\tahmi\\Downloads\\chromedriver");
        options.setCapability("browserName", "Chrome");
		
        //Android Driver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait maximum 10 seconds to run a test
		//Appium code -> Appium server ->  Mobile
        
        //Selenium test
        Thread.sleep(5000);
        driver.get("http://google.com");
        System.out.println(driver.getTitle());
        driver.findElement(AppiumBy.name("q")).sendKeys("appium.io");
	    driver.findElement(AppiumBy.name("q")).sendKeys(Keys.ENTER);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
       
	}
	
	
	
	

}



