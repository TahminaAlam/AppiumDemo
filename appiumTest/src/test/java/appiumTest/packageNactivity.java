package appiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.junit.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class packageNactivity {
	
	@Test
	public void pNa () throws MalformedURLException, InterruptedException {
		
		//code to start the server
		AppiumDriverLocalService Service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\tahmi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		Service.start();
		
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("pixel_3");
        options.setApp("C:\\Users\\tahmi\\eclipse-workspace\\appiumTest\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		//Android Driver
       AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait maximum 10 seconds to run a test
		//Appium code -> Appium server ->  Mobile
	
		
		
		//adb shell dumpsys window | find "mCurrentFocus"     //windows command
		//anything before class is package name and anything after class is activity name
	    Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
	    driver.startActivity(activity);
	    driver.findElement(AppiumBy.className("android.widget.RelativeLayout")).click();
	    driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
	    driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("WI-FI");
	    driver.findElement(AppiumBy.id("android:id/button1")).click();
	    		
//		Thread.sleep(5000);
//	    driver.quit();//stop the driver
//		Service.stop();//code to stop server
		
	}
	
	
	
	

}



