package appiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;



public class Scroll {
	
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
		
		 //using appium scroll while we need to scroll a bit or don't have any selected element/text to scroll 
		boolean canScrollMore;
		do
		{
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
		
		            ImmutableMap.builder()
		            .put("left", 100)
		            .put("top", 100)
		            .put("width", 200)
		            .put("height", 200)
		            .put("direction", "down")
		            .put("percent", 3.0)
		            .build()
		        );
		}
		while (canScrollMore);
		 //Thread.sleep(2000);
		
		//using googleEngine to find element(when we need to scroll until a selected text/element)
		//driver.findElement(AppiumBy.androidUIAutomator("object of Uiscrollable class(call secector()).method(text(\"give the text where you want to scroll\"));"));
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		//Thread.sleep(2000);
		
		driver.quit();//stop the driver
		Service.stop();//code to stop server
		
	}
	
	

}



