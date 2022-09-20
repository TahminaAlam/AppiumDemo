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

public class assignment1 {
	
	@Test
	public void AppiumTest() throws MalformedURLException, InterruptedException {
		
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
	
		
		//Actual Test
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
		driver.findElement(AppiumBy.id("android:id/button2")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
		driver.findElement(AppiumBy.id("android:id/button2")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message")).click();
		driver.findElement(AppiumBy.id("android:id/button3")).click();
		driver.findElement(AppiumBy.accessibilityId("Progress dialog")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/username_edit")).sendKeys("Tahmina");
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/password_edit")).sendKeys("mou123");
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.CheckedTextView)[3]")).click();
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		
		Thread.sleep(5000);
	    driver.quit();//stop the driver
		Service.stop();//code to stop server
		
	}
	
	

}


