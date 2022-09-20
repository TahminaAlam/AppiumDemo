package appiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;



public class dragDrop {
	
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
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		//drag and drop
		WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		 ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 649,
			    "endY", 519
			));
		String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(result , "Dropped!");
		 
        Thread.sleep(3000);
		
		driver.quit();//stop the driver
		Service.stop();//code to stop server
		
	}
	
	

}



