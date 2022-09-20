package appiumTest;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.junit.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Appium extends BaseTest{
	
	@Test
	public void AppiumTest() throws MalformedURLException {
		
//		//code to start the server
//		AppiumDriverLocalService Service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\tahmi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		Service.start();
//		
//		UiAutomator2Options options = new UiAutomator2Options();
//		options.setDeviceName("pixel_3");
//		options.setApp("C:\\Users\\tahmi\\eclipse-workspace\\appiumTest\\src\\test\\java\\resources\\ApiDemos-debug.apk");
//		
//		//Android Driver
//		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait maximum 10 seconds to run a test
//		//Appium code -> Appium server ->  Mobile
//	
		
		//Actual Test
		// Xpath, id, accessibilityId, classname, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Preferences from XML")).click();
		driver.findElement(AppiumBy.className("android.widget.RelativeLayout")).click();
		
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[6]")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[7]")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		//assertion
		String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "Enter your favorite animal");
		
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Dog");
	    driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	    //or// driver.findElement(AppiumBy.id("android:id/button1")).click();
		
	    driver.quit();//stop the driver
		Service.stop();//code to stop server
		
	}
	
	

}

