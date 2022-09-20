package appiumTest;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class LongPress {
	
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
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		//or// driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		//tagName[@attribute='value']
		WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
		//LongClickGesture  //((JavascriptExecutor)driver).executeScript("EVENT", ImmutableMap.of("KEY",((RemoteWebElement)OBJECT).getId(),"duration",MILISECONS ));
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
					ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000 ));
		//Thread.sleep(2000);		   
		String menuText = driver.findElement(AppiumBy.id("android:id/title")).getText();
		Assert.assertEquals(menuText , "Sample menu");    //see the text
		Assert.assertTrue(driver.findElement(AppiumBy.id("android:id/title")).isDisplayed()); //verify the element/text
		Thread.sleep(2000);
		
		driver.quit();//stop the driver
		Service.stop();//code to stop server
		
	}
	
	

}



