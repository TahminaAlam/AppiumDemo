package appiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.offset.PointOption;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;



public class swipe {
	
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
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		WebElement firstImage = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
        //Assertion before swipe
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
		//swipe
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",(((RemoteWebElement) firstImage).getId()),
			    "direction", "left",
			    "percent", 0.75
			));
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");
		
		
		WebElement secoundImage = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[2]"));
        //Assertion before swipe
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[2]")).getAttribute("focusable"),"true");
		//swipe
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",(((RemoteWebElement) secoundImage).getId()),
			    "direction", "left",
			    "percent", 0.75
			));
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[2]")).getAttribute("focusable"),"false");
		
		
		WebElement thirdImage = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[3]"));
        //Assertion before swipe
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[3]")).getAttribute("focusable"),"true");
		//swipe
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",(((RemoteWebElement) thirdImage).getId()),
			    "direction", "left",
			    "percent", 0.75
			));
		//Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[3]")).getAttribute("focusable"),"false");

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "left", 200, "top", 300, "width", 335, "height", 203,
			    "direction", "right",
		    "percent", 0.75));
		Thread.sleep(5000);

		driver.quit();//stop the driver
		Service.stop();//code to stop server
		
	}
	
	

}



